package com.raigarak.apm_god.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.raigarak.apm_god.Apm;
import com.raigarak.apm_god.huds.GameHud;
import com.raigarak.apm_god.huds.MenuHud;


public class MenuScreen extends BaseScreen {

    private MenuHud menuHud;


    public MenuScreen(Apm game){
        super(game);
        camera = new OrthographicCamera();
        viewport = new FitViewport(Apm.WIDTH, Apm.HEIGHT, camera);
        menuHud = new MenuHud(game.getBatch(), game.getManager());
    }

    public void update(float dt) {
        camera.update();
    }




    @Override
    public void show() {

    }

    public void handleInput(float dt) {
        if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {


        }
    }

    @Override
    public void render(float dt) {
        update(dt);

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        game.getBatch().setProjectionMatrix(camera.combined);

        menuHud.update(dt);

        game.getBatch().end();

        menuHud.getPlayButton().addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                game.setScreen(new GameScreen(game));
            }
        });

        menuHud.getExitButton().addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                Gdx.app.exit();
            }
        });



        menuHud.getStage().draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
        viewport.apply(true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        this.dispose();
    }

    @Override
    public void dispose() {
        menuHud.getStage().dispose(); //gets rid of the play button, so it doesn't show in GameScreen

    }
}

package com.raigarak.apm_god.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.raigarak.apm_god.Apm;
import com.raigarak.apm_god.entity.Player;
import com.raigarak.apm_god.huds.GameHud;


public class GameScreen extends BaseScreen{

    private Texture background;
    private Texture playerTexture;
    private GameHud gameHud;
    private Player player;
    private Sprite playerSprite;


    public GameScreen(Apm game){
        super(game);
        background = game.getManager().get("background.png",Texture.class);

        playerTexture = game.getManager().get("player.png", Texture.class);
        playerSprite = new Sprite(playerTexture, 0,0,150,100);
        player = new Player(playerSprite,150,150);


        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        viewport = new StretchViewport(width, height, camera);
        gameHud = new GameHud(game.getBatch(), game.getManager());

       // player.setPosition((viewport.getWorldWidth()-playerTexture.getWidth())/2,viewport.getWorldHeight()/2);
    }

    @Override
    public void show() {

    }

    public void handleInput(float dt) {
        if(Gdx.input.isButtonPressed(Input.Keys.RIGHT)) {
            player.setCursorPosition(Gdx.input.getX(),  Gdx.input.getY(),0);
            viewport.getCamera().unproject(player.getCursorPosition());
            }

        if (player.getPlayerPosition().dst(player.getCursorPosition().x, player.getCursorPosition().y) < 2) {
            player.setPlayerPosition(player.getCursorPosition().x, player.getCursorPosition().y);
        }

        Vector3 delta = player.getCursorPosition().cpy().sub(player.getX(), player.getY(), 0).nor().scl(player.getSpeed() * dt);
        Vector2 newPlayerPosition = player.getPlayerPosition().cpy().add(delta.x, delta.y);

        if (player.getPlayerPosition().dst(newPlayerPosition) > player.getPlayerPosition().dst(player.getCursorPosition().x, player.getCursorPosition().y)) {
            player.setPlayerPosition(player.getCursorPosition().x, player.getCursorPosition().y);
        }
        else
            player.setPlayerPosition(newPlayerPosition.x, newPlayerPosition.y);

        }


    public void update(float dt) {
        handleInput(dt);
        camera.update();
    }



    @Override
    public void render(float dt) {
        update(dt);

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().begin();
        game.getBatch().draw(background,0,0, width, height);
        player.getSprite().draw(game.getBatch());

        gameHud.update(dt);
        game.getBatch().end();
        gameHud.getStage().draw();
    }



    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
       // game.getBatch().dispose();

    }
}



package com.raigarak.apm_god.huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.raigarak.apm_god.Apm;

public class MenuHud extends BaseHud{

    private Skin skin;
    private TextButton playButton;
    private TextButton exitButton;

    public TextButton getPlayButton() {
        return playButton;
    }

    public TextButton getExitButton() {
        return exitButton;
    }

    public MenuHud(SpriteBatch sb, AssetManager manager) {
        viewport = new StretchViewport(Apm.WIDTH, Apm.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        skin = manager.get("lolskins.json", Skin.class);

        playButton = new TextButton("Play", skin, "default");
        playButton.setWidth(200);
        playButton.setHeight(40);
        playButton.setPosition((Apm.WIDTH - playButton.getWidth())/2,(Apm.HEIGHT - playButton.getHeight())/2);

        exitButton = new TextButton("Exit", skin, "default");
        exitButton.setWidth(200);
        exitButton.setHeight(40);
        exitButton.setPosition((Apm.WIDTH - exitButton.getWidth())/2,(Apm.HEIGHT - exitButton.getHeight() - 100)/2);

        stage.addActor(playButton);
        stage.addActor(exitButton);

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void update(float dt) {

    }


}

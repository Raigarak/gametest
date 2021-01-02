package com.raigarak.apm_god.huds;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.raigarak.apm_god.Apm;


public class GameHud extends BaseHud {
    //private Stage stage;
    //private Viewport viewport; //make new camera because when the game world moves we still want the hud to stay the same
    private BitmapFont font;

    private int score = 0;

    private Label scoreLabel;
    private Label scoreTextLabel;

    public GameHud(SpriteBatch sb, AssetManager manager) {
        viewport = new StretchViewport(Apm.WIDTH, Apm.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        font = manager.get("specialFont.fnt", BitmapFont.class);

        Table table = new Table();
        table.top();
        table.setFillParent(true); //table is now the size of our stage

        scoreLabel = new Label(String.format("%01d", score), new Label.LabelStyle(font, Color.WHITE));
        scoreTextLabel = new Label("Score", new Label.LabelStyle(font, Color.WHITE));

        table.add(scoreTextLabel);
        table.row();
        table.add(scoreLabel);

        stage.addActor(table);
    }
    public void update(float dt) {
        score++;
        scoreLabel.setText((String.format("%1d", score)));
    }



}

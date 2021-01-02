package com.raigarak.apm_god.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.raigarak.apm_god.Apm;
import com.raigarak.apm_god.Assets;

public abstract class BaseScreen implements Screen {

    protected SpriteBatch batch;
    protected Apm game;
    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected float width;
    protected float height;

    public BaseScreen(Apm game) {
        this.game = game;
        this.batch = game.getBatch();
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();

    }

    public abstract void update(float dt);

    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
    }
  //  public abstract void render(SpriteBatch sb);
}

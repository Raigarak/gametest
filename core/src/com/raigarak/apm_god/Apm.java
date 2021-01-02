package com.raigarak.apm_god;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.raigarak.apm_god.screens.GameScreen;
import com.raigarak.apm_god.screens.MenuScreen;

import java.awt.*;

public class Apm extends Game {

	public static final int WIDTH = 900;
	public static final int HEIGHT = 700;

	private SpriteBatch batch;
	private BitmapFont font;

	private Assets assets;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();



		//Loading all the assets
		assets = new Assets();
		assets.load();
		assets.getManager().finishLoading();

		this.setScreen(new MenuScreen(this));
	}

	public AssetManager getManager() {
		return this.assets.getManager();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	@Override //Delegates the render method to whatever screen is active at the time
	public void render () {
		super.render();
		this.assets.getManager().update();

		//gsm.update(Gdx.graphics.getDeltaTime());
		//gsm.render(batch);
	}

	public void dispose() {
	    batch.dispose();
		//this.assets.getManager().dispose();
    }
}

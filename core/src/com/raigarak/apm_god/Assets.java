package com.raigarak.apm_god;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    private AssetManager manager;

    public void load() {
        manager = new AssetManager();

        manager.load("specialFont.fnt", BitmapFont.class);
        manager.load("background.png", Texture.class);
        manager.load("player.png", Texture.class);
        manager.load("lolskins.json", Skin.class);
    }



    public AssetManager getManager(){
        return this.manager;
    }
}

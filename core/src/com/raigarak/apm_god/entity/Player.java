package com.raigarak.apm_god.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.raigarak.apm_god.Apm;

public class Player extends GameObject {

    private Vector2 playerPosition;
    private Vector3 cursorPosition;

    public Player(Sprite sprite, float x, float y) {
        super(sprite, x, y);
        playerPosition = new Vector2();
        cursorPosition = new Vector3();
        sprite.setPosition(x, y);
        speed = 300;
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }


    public Vector2 getPlayerPosition() {
        return playerPosition;
    }

    public Vector3 getCursorPosition() {
        return cursorPosition;
    }

    public void setPlayerPosition(float x, float y) {
        this.playerPosition.set(x, y);
        this.sprite.setPosition(playerPosition.x,playerPosition.y);
    }

    public void setCursorPosition(float x, float y, float z) {
        this.cursorPosition.set(x, y, z);
    }

}

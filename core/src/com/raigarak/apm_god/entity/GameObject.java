package com.raigarak.apm_god.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class GameObject {

    protected float x, y;
    protected float dx, dy;
    protected Sprite sprite;
    protected float speed;

    public GameObject(Sprite sprite, float x, float y) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }


    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }



    public void update(float dt) {

    }


}

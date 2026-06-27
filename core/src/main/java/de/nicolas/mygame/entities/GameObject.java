package de.nicolas.mygame.entities;

import com.badlogic.gdx.math.Vector2;

public class GameObject {

    private float x;
    private float y;
    private float width;
    private float height;

    public GameObject(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
}

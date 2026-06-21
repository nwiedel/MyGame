package de.nicolas.mygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Vector2 position;
    private Vector2 movement;
    private float speed;
    private float width;
    private float height;
    private int health;

    public Player(float x, float y){
        position = new Vector2(x, y);
        movement = new Vector2();
        speed = 220f;
        width = 64f;
        height = 64f;
        health = 3;
    }

    public void update(float delta){
        handleInput();
        move(delta);
        clampToScreen();
    }

    private void handleInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ||
            Gdx.input.isKeyPressed(Input.Keys.D)){
            movement.x += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ||
            Gdx.input.isKeyPressed(Input.Keys.A)){
            movement.x -= 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) ||
            Gdx.input.isKeyPressed(Input.Keys.W)){
            movement.y += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) ||
            Gdx.input.isKeyPressed(Input.Keys.S)){
            movement.y -= 1;
        }

        if (movement.len2() > 0){
            movement.nor();
        }
    }

    private void move(float delta){
        position.x += movement.x * speed * delta;
        position.y += movement.y * speed * delta;
    }

    private void clampToScreen(){
        if (position.x < 0){
            position.x = 0;
        }
        if (position.y < 0){
            position.y = 0;
        }
        if (position.x + width > Gdx.graphics.getWidth()){
            position.x = Gdx.graphics.getWidth() - width;
        }
        if (position.y + height > Gdx.graphics.getHeight()){
            position.y = Gdx.graphics.getHeight() - height;
        }
    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public int getHealth() {
        return health;
    }
}

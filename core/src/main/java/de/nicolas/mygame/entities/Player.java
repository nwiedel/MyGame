package de.nicolas.mygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import de.nicolas.mygame.utils.GameConfig;

public class Player {

    private Vector2 position;
    //private Vector2 movement;
    private float speed;
    private float width;
    private float height;
    private int health;

    public Player(float x, float y){
        position = new Vector2(x, y);
        //movement = new Vector2();
        speed = GameConfig.PLAYER_SPEED;
        width = 64f;
        height = 64f;
        health = 3;
    }

    public void update(float delta, Vector2 movement){
        position.x += movement.x * speed * delta;
        position.y += movement.y * speed * delta;
        clampToScreen();
    }

    private void clampToScreen(){
        if (position.x < 0){
            position.x = 0;
        }
        if (position.y < 0){
            position.y = 0;
        }
        if (position.x + width > GameConfig.WORLD_WIDTH){
            position.x = GameConfig.WORLD_WIDTH - width;
        }
        if (position.y + height > GameConfig.WORLD_HEIGHT){
            position.y = GameConfig.WORLD_HEIGHT - height;
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

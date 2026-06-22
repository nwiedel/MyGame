package de.nicolas.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class InputHandler {

    public Vector2 getMovement(){
        Vector2 movement = new Vector2();

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

        return movement;
    }
}

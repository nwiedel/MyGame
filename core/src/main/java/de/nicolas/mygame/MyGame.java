package de.nicolas.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import de.nicolas.mygame.utils.GameConfig;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MyGame extends ApplicationAdapter {

    private float playerX;
    private float playerY;
    private float playerSpeed;

    @Override
    public void create() {
        playerX = 100f;
        playerY = 100f;
        playerSpeed = 120f;
    }



    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        handleInput(delta);
        update(delta);
        draw();
    }

    private void handleInput(float delta){
        // Tastatur, mouse, Touch, Gamepad
    }

    private void update(float delta){
        //Bewegung, Kollision, Timer und Spiellogik

        playerX += playerSpeed * delta;
    }

    private void draw(){
        // Zeichnen
        
        ScreenUtils.clear(GameConfig.CORNFLOWER_BLUE);
    }

    @Override
    public void dispose() {

    }
}

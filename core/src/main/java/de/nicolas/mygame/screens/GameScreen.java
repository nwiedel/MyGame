package de.nicolas.mygame.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import de.nicolas.mygame.MyGame;

public class GameScreen implements Screen {

    private final MyGame game;

    private SpriteBatch batch;
    private Texture playerTexture;

    private float playerX;
    private float playerY;
    private float playerWidth;
    private float playerHeight;

    public GameScreen(MyGame game){
        this.game = game;
    }

    @Override
    public void show() {
        // Aufruf einmalig zu Beginn

        batch = new SpriteBatch();
        playerTexture = new Texture("player.png");
        playerX = 100;
        playerY = 100;
        playerWidth = 128;
        playerHeight = 128;
    }

    @Override
    public void render(float delta) {
        // Aufruf in jedem Frame
        update(delta);
        draw();
    }

    @Override
    public void resize(int width, int height) {
        // behandele screen resize
    }

    @Override
    public void pause() {
        // Aufruf, wenn die App pausiert wird
    }

    @Override
    public void resume() {
        // Aufruf, wenn die App fortgesetzt wird
    }

    @Override
    public void hide() {
        // Aufruf, wenn der Screen minimiert wird
    }

    @Override
    public void dispose() {
        // säubert überflüssige Ressourcen
        batch.dispose();
        playerTexture.dispose();
    }

    // == private Methoden ==
    private void update(float delta){
        // Spielelogik
        playerX += 50 * delta;
    }

    private void draw(){
        // das Zeichnen

        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1f);

        batch.begin();
        batch.draw(playerTexture, playerX, playerY, playerWidth, playerHeight);
        batch.end();
    }
}

package de.nicolas.mygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import de.nicolas.mygame.InputHandler;
import de.nicolas.mygame.MyGame;
import de.nicolas.mygame.ScreenType;
import de.nicolas.mygame.entities.Player;
import de.nicolas.mygame.utils.GameConfig;

public class GameScreen implements Screen {

    private final MyGame game;

    private SpriteBatch batch;
    private OrthographicCamera camera;

    private Player player;

    private Texture playerTexture;

    private boolean paused;

    private InputHandler inputHandler;

    public GameScreen(MyGame game){
        this.game = game;

        batch = game.getBatch();

        camera = game.getCamera();
        camera.setToOrtho(false, 960, 540);
    }

    @Override
    public void show() {
        // Aufruf einmalig zu Beginn
        playerTexture = new Texture("player.png");

        player = new Player(100, 100);

        paused = false;

        inputHandler = new InputHandler();
    }

    @Override
    public void render(float delta) {
        // Aufruf in jedem Frame
        update(delta);
        draw();
    }

    private void update(float delta){
        // Spielelogik
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)){
            paused = !paused;
        }
        if (paused){
            return;
        }

        Vector2 movement = inputHandler.getMovement();
        player.update(delta, movement);

        if (player.getHealth() <= 0){
            game.changeScreen(ScreenType.GAME_OVER);
        }
    }

    private void draw(){
        // das Zeichnen

        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1f);

        //updateCamera();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        drawWorld();
        drawPlayer();

        batch.end();
    }

    private void drawWorld(){}

    private void drawPlayer(){
        batch.draw(playerTexture, player.getX(), player.getY(),
            player.getWidth(), player.getHeight());
    }

    private void updateCamera(){
        camera.position.set(player.getX() + player.getWidth() / 2f,
            player.getY() + player.getHeight() / 2f, 0);
        camera.update();
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
        playerTexture.dispose();
    }
}

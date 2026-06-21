package de.nicolas.mygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import de.nicolas.mygame.MyGame;
import de.nicolas.mygame.utils.GameConfig;

public class GameScreen implements Screen {

    private final MyGame game;

    private SpriteBatch batch;
    private OrthographicCamera camera;

    private Texture playerTexture;

    private float playerX;
    private float playerY;
    private float playerWidth;
    private float playerHeight;
    private float playerSpeed;
    private Vector2 movement;

    private Screen oldScreen;

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

        playerX = 100;
        playerY = 100;
        playerWidth = 64;
        playerHeight = 64;
        playerSpeed = 220;
        movement = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        // Aufruf in jedem Frame
        update(delta);
        draw();
    }

    private void update(float delta){
        // Spielelogik
        handleInput(delta);
        keepPlayerInsideScreen();
    }

    private void handleInput(float delta){
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

            playerX += movement.x * playerSpeed * delta;
            playerY += movement.y * playerSpeed * delta;
        }

        movement.set(0, 0);

        if (Gdx.input.isKeyPressed(Input.Keys.F2)){
            oldScreen = game.getScreen();
            game.setScreen(new MenuScreen(game));

            if (oldScreen != null){
                oldScreen.dispose();
            }
        }
    }

    private void keepPlayerInsideScreen(){
        if (playerX < 0){
            playerX = 0;
        }
        if (playerY < 0){
            playerY = 0;
        }
        if (playerX + playerWidth > Gdx.graphics.getWidth()){
            playerX = Gdx.graphics.getWidth() - playerWidth;
        }
        if (playerY + playerHeight > Gdx.graphics.getHeight()){
            playerY = Gdx.graphics.getHeight() - playerHeight;
        }
    }

    private void draw(){
        // das Zeichnen

        ScreenUtils.clear(GameConfig.CORNFLOWER_BLUE);

        updateCamera();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        drawWorld();
        drawPlayer();

        batch.end();
    }

    private void drawWorld(){}

    private void drawPlayer(){
        batch.draw(playerTexture, playerX, playerY, playerWidth, playerHeight);
    }

    private void updateCamera(){
        camera.position.set(playerX + playerWidth / 2f, playerY + playerHeight / 2f, 0);
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
        oldScreen = null;
    }
}

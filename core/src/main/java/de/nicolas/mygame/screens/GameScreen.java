package de.nicolas.mygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.nicolas.mygame.InputHandler;
import de.nicolas.mygame.MyGame;
import de.nicolas.mygame.ScreenType;
import de.nicolas.mygame.entities.Player;
import de.nicolas.mygame.utils.GameConfig;

public class GameScreen implements Screen {

    private final MyGame game;

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Player player;
    private float playerRotation;

    private Texture playerTexture;
    private TextureRegion playerRegion;
    private TextureRegion[] idleFrames;
    private Texture backgroundTexture;

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
        viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);

        backgroundTexture = new Texture("background.png");
        playerTexture = new Texture("player/fox/idle.png");
        playerRegion = new TextureRegion(playerTexture, 0, 0, 32, 32);

        TextureRegion[][] idleSplitFrames = TextureRegion.split(playerTexture, 32, 32);

        idleFrames = new TextureRegion[11];
        idleFrames[0] = idleSplitFrames[0][0];
        idleFrames[1] = idleSplitFrames[0][1];
        idleFrames[2] = idleSplitFrames[0][2];
        idleFrames[3] = idleSplitFrames[0][3];
        idleFrames[4] = idleSplitFrames[0][4];
        idleFrames[5] = idleSplitFrames[0][5];
        idleFrames[6] = idleSplitFrames[0][6];
        idleFrames[7] = idleSplitFrames[0][7];
        idleFrames[8] = idleSplitFrames[0][8];
        idleFrames[9] = idleSplitFrames[0][9];
        idleFrames[10] = idleSplitFrames[0][10];

        player = new Player(100, 100);

        paused = false;

        inputHandler = new InputHandler();
    }

    @Override
    public void render(float delta) {
        // Aufruf in jedem Frame
        update(delta);
        draw();

        /*
        Reihenfolge des zeichnens

        Hintergrund
        statische Objekte
        Collectibles
        Gegener
        Player
        Effekte
        UI

         */
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

        // Spielerrotatio
        playerRotation += 180f * delta;
        if (playerRotation >= 360F) {
            playerRotation -= 360f;
        }
    }

    private void draw(){
        // das Zeichnen

        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1f);

        viewport.apply();
        updateCamera();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        drawWorld();
        drawPlayer();

        batch.end();
    }

    private void drawWorld(){
        batch.draw(backgroundTexture, 0, 0,
            backgroundTexture.getWidth(), backgroundTexture.getHeight());
    }

    private void drawPlayer(){
        batch.draw(idleFrames[10], player.getX(), player.getY(),
            player.getWidth(), player.getHeight());

        // zeichnen mit Rotation
        /*batch.draw(idleFrames[1].getTexture(),
            player.getX(), player.getY(),
            player.getWidth() / 2, player.getHeight() /2,
            player.getWidth(), player.getHeight(),
            1, 1, playerRotation, 0, 0,
            idleFrames[1].getRegionWidth(), idleFrames[1].getRegionHeight(),
            false, false);*/
    }

    private void updateCamera(){
        camera.position.set(player.getX() + player.getWidth() / 2f,
            player.getY() + player.getHeight() / 2f, 0);
        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        // behandele screen resize
        viewport.update(width, height, true);
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

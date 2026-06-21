package de.nicolas.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.nicolas.mygame.platform.PlatformServices;
import de.nicolas.mygame.screens.GameOverScreen;
import de.nicolas.mygame.screens.GameScreen;
import de.nicolas.mygame.screens.MenuScreen;
import de.nicolas.mygame.screens.PauseScreen;

public class MyGame extends Game {

    private final PlatformServices platformServices;

    private SpriteBatch batch;
    private OrthographicCamera camera;

    public MyGame(PlatformServices platformServices){
        this.platformServices = platformServices;

    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        setScreen(new MenuScreen(this));
    }

    public void changeScreen(ScreenType screenType){
        Screen oldScreen = getScreen();

        switch (screenType){
            case MENU:
                setScreen(new MenuScreen(this));
                break;
            case GAME:
                setScreen(new GameScreen(this));
                break;
            case PAUSE:
                setScreen(new PauseScreen(this));
                break;
            case GAME_OVER:
                setScreen(new GameOverScreen(this));
                break;
            default:
                break;
        }

        if (oldScreen != null){
            oldScreen.dispose();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

    public PlatformServices getPlatformServices() {
        return platformServices;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}

package de.nicolas.mygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.nicolas.mygame.platform.PlatformServices;
import de.nicolas.mygame.screens.MenuScreen;

public class MyGame extends Game {

    private final PlatformServices platformServices;

    private SpriteBatch batch;

    public MyGame(PlatformServices platformServices){
        this.platformServices = platformServices;

    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new MenuScreen(this));
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
}

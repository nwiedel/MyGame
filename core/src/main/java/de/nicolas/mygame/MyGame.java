package de.nicolas.mygame;

import com.badlogic.gdx.Game;
import de.nicolas.mygame.platform.PlatformServices;
import de.nicolas.mygame.screens.GameScreen;

public class MyGame extends Game {

    private final PlatformServices platformServices;

    public MyGame(PlatformServices platformServices){
        this.platformServices = platformServices;
    }

    @Override
    public void create() {
        setScreen(new GameScreen(this));
    }

    public PlatformServices getPlatformServices() {
        return platformServices;
    }
}

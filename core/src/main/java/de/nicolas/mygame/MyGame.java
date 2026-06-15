package de.nicolas.mygame;

import com.badlogic.gdx.Game;
import de.nicolas.mygame.screens.GameScreen;

public class MyGame extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen(this));
    }
}

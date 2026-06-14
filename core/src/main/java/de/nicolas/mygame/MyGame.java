package de.nicolas.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import de.nicolas.mygame.utils.GameConfig;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MyGame extends ApplicationAdapter {

    @Override
    public void create() {
        System.out.println("Spiel gestartet!");
    }

    @Override
    public void render() {
        ScreenUtils.clear(GameConfig.CORNFLOWER_BLUE);

        System.out.println("Frame gezeichent!");
    }

    @Override
    public void dispose() {
        System.out.println("Spiel beendet!");
    }
}

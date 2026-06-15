package de.nicolas.mygame.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import de.nicolas.mygame.MyGame;

public class GameScreen implements Screen {

    private MyGame game;

    public GameScreen(MyGame game){
        this.game = game;
    }

    @Override
    public void show() {
        // Aufruf einmalig zu Beginn
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
    }

    // == private Methoden ==
    private void update(float delta){
        // Spielelogik
    }

    private void draw(){
        // das Zeichnen

        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1f);
    }
}

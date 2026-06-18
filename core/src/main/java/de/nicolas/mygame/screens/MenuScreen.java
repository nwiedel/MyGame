package de.nicolas.mygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import de.nicolas.mygame.MyGame;

public class MenuScreen implements Screen {

    private final MyGame game;

    private Screen oldScreen;

    public MenuScreen(MyGame game){
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta){
        handleInput(delta);
    }

    private void handleInput(float delta){

        if (Gdx.input.isKeyPressed(Input.Keys.F1)){
            oldScreen = game.getScreen();
            game.setScreen(new GameScreen(game));

            if (oldScreen != null){
                oldScreen.dispose();
            }
        }
    }

    public void draw(){
        ScreenUtils.clear(0.1f, 0.1f, 0.15f, 1f);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        oldScreen = null;
    }
}

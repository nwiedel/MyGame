package de.nicolas.mygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import de.nicolas.mygame.MyGame;
import de.nicolas.mygame.ScreenType;

public class GameOverScreen implements Screen {

    private MyGame game;

    public GameOverScreen(MyGame game){
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

    public void update(float delta){
        handleInput(delta);
    }

    public void handleInput(float delta){
        // Der Tastendruck soll nur einmal zur Ausführung führen --> isKeyJustPressed
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)){
            game.changeScreen(ScreenType.GAME);
        }
        // Der Tastendruck soll nur einmal zur Ausführung führen --> isKeyJustPressed
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            game.changeScreen(ScreenType.MENU);
        }

    }

    public void draw(){

        ScreenUtils.clear(0.12f, 0.04f, 0.04f, 1f);
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
    }
}

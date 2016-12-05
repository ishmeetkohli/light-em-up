package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.screens.SplashScreen;

public class BulbGame extends Game implements InputProcessor {
    SpriteBatch batch;
    ShapeRenderer shapeRenderer;

    @Override
    public void create() {
//		Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
//		screen = new GameScreen(batch);
        screen = new SplashScreen(batch, shapeRenderer);
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keyCode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

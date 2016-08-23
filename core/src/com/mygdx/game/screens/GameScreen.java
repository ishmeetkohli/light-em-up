package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.logic.Level;
import com.mygdx.game.logic.LevelRenderer;
import com.mygdx.game.objects.Assets;

/**
 * Created by ikohli on 8/19/2016.
 */
public class GameScreen implements Screen {

    SpriteBatch batch;
    Level level;
    LevelRenderer levelRenderer;

    AssetManager assetManager;

    public GameScreen(SpriteBatch batch) {
        level = new Level();
        levelRenderer = new LevelRenderer(level);
        this.batch = batch;
        assetManager = new AssetManager();
        assetManager.load("packedImages/GameScreen.atlas", TextureAtlas.class);
        assetManager.finishLoading();
        Assets.load(assetManager);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        levelRenderer.render(batch);
        batch.end();
    }

    public void update(float delta) {
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

package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.logic.Level;
import com.mygdx.game.objects.Assets;

/**
 * Created by ikohli on 8/19/2016.
 */
public class GameScreen implements Screen {

    public static final float SCREEN_WIDTH = 480;
    public static final float SCREEN_HEIGHT = 800;

    SpriteBatch batch;
    Level level;
    public ShapeRenderer shape;
    OrthographicCamera guiCam;

    AssetManager assetManager;

    public GameScreen(SpriteBatch batch) {
        assetManager = new AssetManager();
        assetManager.load("packedImages/GameScreen.atlas", TextureAtlas.class);
        assetManager.finishLoading();
        Assets.load(assetManager);

        guiCam = new OrthographicCamera(480, 800);
        guiCam.position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, 0);

        level = new Level();
        this.batch = batch;
        shape = new ShapeRenderer();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        Gdx.gl20.glEnable(GL20.GL_TEXTURE_2D);

        batch.setProjectionMatrix(guiCam.combined);
        batch.enableBlending();
        batch.begin();
        level.render(batch, shape);
        batch.end();
    }

    public void update(float delta) {
        guiCam.update();
        level.update(delta);
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

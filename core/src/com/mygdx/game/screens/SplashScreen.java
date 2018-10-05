package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.objects.Assets;
import com.mygdx.game.utils.Constants;

/**
 * Created by Ishmeet on 01/12/16.
 */

public class SplashScreen implements Screen {

    OrthographicCamera guiCam;
    Game game;

    SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    private Sprite playSign;

    AssetManager assetManager;

    public TextureAtlas splashAtlas;

    Screen current, next;

    public SplashScreen(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        guiCam = new OrthographicCamera(Constants.FRUSTUM_WIDTH, Constants.FRUSTUM_HEIGHT);
        guiCam.position.set(Constants.FRUSTUM_WIDTH / 2, Constants.FRUSTUM_HEIGHT / 2, 0);

        splashAtlas = new TextureAtlas(Gdx.files.internal("packedImages/SplashScreen.atlas"));
        playSign = splashAtlas.createSprite("play");

        assetManager = new AssetManager();
        assetManager.load("packedImages/GameScreen.atlas", TextureAtlas.class);

        this.batch = batch;
        this.shapeRenderer = shapeRenderer;
    }


    @Override
    public void show() {

    }

    private void update(float delta) {
        if (assetManager.update()) {
            Assets.load(assetManager);
            next = new GameScreen(batch);
            game.setScreen(next);
        }
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        Gdx.gl20.glEnable(GL20.GL_TEXTURE_2D);

        shapeRenderer.setProjectionMatrix(guiCam.combined);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.rect(-Constants.FRUSTUM_WIDTH/2, -Constants.FRUSTUM_HEIGHT/2, Constants.FRUSTUM_WIDTH, Constants.FRUSTUM_HEIGHT * assetManager.getProgress());

        System.out.println(assetManager.getProgress());

        shapeRenderer.end();

        batch.setProjectionMatrix(guiCam.combined);
        batch.enableBlending();
        batch.begin();
        Assets.draw(playSign, 0, 0, batch);
        batch.end();




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

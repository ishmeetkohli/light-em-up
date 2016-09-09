package com.mygdx.game.objects;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.logic.LevelRenderer;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by ikohli on 8/19/2016.
 */
public class Assets {
    public static TextureAtlas gameScreenAtlas;

    //Game Screen
    public static Sprite bulb_on;
    public static Sprite bulb_off;

    public static Sprite circle;

    public static void load(AssetManager assetManager) {
        gameScreenAtlas = assetManager.get("packedImages/GameScreen.atlas", TextureAtlas.class);

        bulb_on = gameScreenAtlas.createSprite("bulb_on");
        bulb_on.setSize(0.3f * LevelRenderer.MULTIPLICATION_FACTOR * bulb_on.getWidth(), 0.3f * LevelRenderer.MULTIPLICATION_FACTOR * bulb_on.getHeight());

        bulb_off = gameScreenAtlas.createSprite("bulb_off");
        bulb_off.setSize(0.3f * LevelRenderer.MULTIPLICATION_FACTOR * bulb_off.getWidth(), 0.3f * LevelRenderer.MULTIPLICATION_FACTOR * bulb_off.getHeight());

        circle = gameScreenAtlas.createSprite("circle");
        circle.setSize(0.5f * LevelRenderer.MULTIPLICATION_FACTOR * circle.getWidth(), 0.5f * LevelRenderer.MULTIPLICATION_FACTOR * circle.getHeight());
    }

    public static void draw(Sprite sprite, float x, float y, SpriteBatch batch){
        sprite.setPosition(x - sprite.getWidth() / 2, y - sprite.getHeight() / 2);
        sprite.draw(batch);
    }
}



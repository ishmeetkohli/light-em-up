package com.mygdx.game.objects;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by ikohli on 8/19/2016.
 */
public class Assets {
    public static TextureAtlas gameScreenAtlas;

    //Game Screen
    public static Sprite bulb_on;
    public static Sprite bulb_off;

    public static void load(AssetManager assetManager) {
        gameScreenAtlas = assetManager.get("packedImages/GameScreen.atlas", TextureAtlas.class);

        bulb_on = gameScreenAtlas.createSprite("bulb_on");
        bulb_off = gameScreenAtlas.createSprite("bulb_off");
    }
}


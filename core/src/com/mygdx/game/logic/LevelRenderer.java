package com.mygdx.game.logic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Assets;

/**
 * Created by ikohli on 8/11/2016.
 */
public class LevelRenderer {

    Level level;
    boolean[][] table;

    public LevelRenderer(Level level) {
        this.level = level;
        this.table = level.getTable();
    }

    public void render(SpriteBatch batch) {
        for(int i = 0; i < table.length; i++){
            for(int j=0; j < table[0].length; j++){
                Sprite bulb = table[i][j] ? Assets.bulb_on : Assets.bulb_off;
                bulb.setScale(0.3f);
                bulb.setPosition(i*50,j*50);
                bulb.draw(batch);
            }
        }


    }
}

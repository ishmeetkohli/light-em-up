package com.mygdx.game.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.mygdx.game.objects.Assets;

import java.util.Random;

/**
 * Created by ikohli on 8/11/2016.
 */
public class Level {
    int rowNumber = 10;
    boolean[][] bulbTable;
    Random rand;

    public Level() {
        rand = new Random();
        bulbTable = new boolean[rowNumber][rowNumber];
        initTable();
    }

    private void initTable() {

        for (int i = 0; i < bulbTable.length; i++) {
            for (int j = 0; j < bulbTable[0].length; j++) {
                bulbTable[i][j] = rand.nextBoolean();
            }
        }
    }

    public boolean[][] getTable() {
        return bulbTable;
    }

}

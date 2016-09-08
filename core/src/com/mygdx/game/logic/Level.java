package com.mygdx.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.objects.Bulb;
import com.mygdx.game.tools.OverlapTester;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ikohli on 8/11/2016.
 */
public class Level {
    int rowNumber = 10;
    Bulb[][] bulbTable;
    Random rand;
    LevelRenderer levelRenderer;
    Vector3 touchPoint;

    public Level() {
        levelRenderer = new LevelRenderer();
        bulbTable = new Bulb[rowNumber][rowNumber];
        touchPoint = new Vector3();
        rand = new Random();
        initTable();
    }

    private void initTable() {
        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= rowNumber; j++) {
                Bulb bulb = new Bulb(i, j);
                bulb.setState(rand.nextBoolean());
                bulb.setIndexes(i, j);
                bulbTable[i - 1][j - 1] = bulb;
            }
        }
    }

    public void toggleBulbs(int rowIndex, int columnIndex) {
        for (Bulb[] bulbRow : bulbTable) {
            for (Bulb bulb : bulbRow) {
                if (bulb.getRowIndex() == rowIndex || bulb.getColumnIndex() == columnIndex) {
                    bulb.toggle();
                }
            }
        }
    }

    public void render(SpriteBatch batch, ShapeRenderer shape) {
        levelRenderer.render(batch, shape, bulbTable);
    }

    public void update(float delta) {
        if (Gdx.input.justTouched()) {
            levelRenderer.getCam().unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

            for (Bulb[] bulbRow : bulbTable) {
                for (Bulb bulb : bulbRow) {
                    if (OverlapTester.pointInRectangle(bulb.getBounds(), touchPoint.x, touchPoint.y)) {
                        toggleBulbs(bulb.getRowIndex(), bulb.getColumnIndex());
                    }
                }
            }
        }

    }
}

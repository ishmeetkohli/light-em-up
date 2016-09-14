package com.mygdx.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.objects.Bulb;
import com.mygdx.game.tools.OverlapTester;

import java.util.Random;

/**
 * Created by ikohli on 8/11/2016.
 */
public class Level {
    public static final int GAME_INITIALIZING = 0;
    public static final int GAME_RUNNING = 1;
    public static final int GAME_TOGGLING = 2;

    int rowNumber = 10;
    Bulb[][] bulbTable;
    Random rand;
    LevelRenderer levelRenderer;
    Vector3 touchPoint;
    int state;
    Bulb toggledBulb;

    public Level() {
        levelRenderer = new LevelRenderer();
        bulbTable = new Bulb[rowNumber][rowNumber];
        touchPoint = new Vector3();
        rand = new Random();
        initTable();

        state = GAME_INITIALIZING;
    }

    private void initTable() {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < rowNumber; j++) {
                Bulb bulb = new Bulb(i, j);
                bulb.setState(false);
                bulb.setIndexes(i, j);
                bulbTable[i][j] = bulb;
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

    float stateTime = 1;

    public void randomize() {
        if (stateTime % 20 == 0) {
            toggleBulbs(rand.nextInt(rowNumber), rand.nextInt(rowNumber));
        }
        if (stateTime > 360) {
            state = GAME_RUNNING;
        }
        stateTime++;
    }

    public void update(float delta) {
        switch (state) {
            case GAME_INITIALIZING:
                updateInitializing(delta);
                break;
            case GAME_RUNNING:
                updateRunning(delta);
                break;
            case GAME_TOGGLING:
                updateToggling(delta);
                break;
        }
    }

    int rowFwd, rowBack, columnFwd, columnBack;
    private void updateToggling(float delta) {

        if (rowFwd < rowNumber) {
            bulbTable[rowFwd++][toggledBulb.getColumnIndex()].toggle();
        }

        if (rowBack >= 0) {
            bulbTable[rowBack--][toggledBulb.getColumnIndex()].toggle();
        }

        if (columnFwd < rowNumber) {
            bulbTable[toggledBulb.getRowIndex()][columnFwd++].toggle();
        }

        if (columnBack >= 0) {
            bulbTable[toggledBulb.getRowIndex()][columnBack--].toggle();
        }

        if(rowFwd == rowNumber && rowBack < 0 && columnFwd == rowNumber && columnBack < 0) {
            state = GAME_RUNNING;
        }
    }

    public void updateInitializing(float deltaTime) {
        randomize();
    }

    public void updateRunning(float deltaTime) {

        if (Gdx.input.justTouched()) {
            levelRenderer.getCam().unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

            for (Bulb[] bulbRow : bulbTable) {
                for (Bulb bulb : bulbRow) {
                    if (OverlapTester.pointInRectangle(bulb.getBounds(), touchPoint.x, touchPoint.y)) {
                        bulb.toggle();
                        toggledBulb = bulb;
                        rowFwd = toggledBulb.getRowIndex();
                        rowBack = toggledBulb.getRowIndex();
                        columnFwd = toggledBulb.getColumnIndex();
                        columnBack = toggledBulb.getColumnIndex();
                        state = GAME_TOGGLING;
                    }
                }
            }
        }
    }
}

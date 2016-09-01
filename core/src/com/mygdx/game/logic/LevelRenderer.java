package com.mygdx.game.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.objects.Bulb;
import com.mygdx.game.screens.GameScreen;

import java.util.ArrayList;

/**
 * Created by ikohli on 8/11/2016.
 */
public class LevelRenderer {
    public static final float FRUSTUM_WIDTH = 12;
    public static final float FRUSTUM_HEIGHT = 20;
    public static final float MULTIPLICATION_FACTOR = FRUSTUM_HEIGHT / GameScreen.SCREEN_HEIGHT;

    OrthographicCamera cam;

    public LevelRenderer() {
        this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
        this.cam.position.set(FRUSTUM_WIDTH / 2, FRUSTUM_HEIGHT / 2, 0);
    }

    public void render(SpriteBatch batch, ShapeRenderer shape, Bulb[][] bulbTable) {
        cam.update();

        if (shape != null) {
            shape.setProjectionMatrix(cam.combined);
            shape.begin(ShapeRenderer.ShapeType.Line);
        }

        batch.setProjectionMatrix(cam.combined);

        for (Bulb[] bulbRow : bulbTable) {
            for (Bulb bulb : bulbRow) {
                bulb.render(batch);

                if (shape != null) {
                    shape.rect(bulb.getBounds().getX(), bulb.getBounds().getY(), bulb.getBounds().getWidth(), bulb.getBounds().getHeight());
                }
            }
        }

        if (shape != null) {
            shape.end();
        }

    }

    public OrthographicCamera getCam() {
        return cam;
    }
}

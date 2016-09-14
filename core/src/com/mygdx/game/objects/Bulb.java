package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Utils.Colors;
import com.mygdx.game.tools.GameObject;

/**
 * Created by ikohli on 8/17/2016.
 */
public class Bulb extends GameObject {

    public static final float BULB_WIDTH = Assets.circle.getWidth();
    public static final float BULB_HEIGHT = Assets.circle.getHeight();

    boolean isOn;
    int rowIndex;
    int columnIndex;

    public Bulb(float x, float y) {
        super(x + 1, y + 1, BULB_WIDTH, BULB_HEIGHT);
        isOn = false;
    }

    public void setIndexes(int row, int column) {
        this.rowIndex = row;
        this.columnIndex = column;
    }

    public void setState(boolean isOn) {
        this.isOn = isOn;
    }

    public void render(SpriteBatch batch) {
        Color color = isOn ? Color.RED : Colors.CYAN;
        Assets.circle.setColor(color);
        Assets.draw(Assets.circle, getPosition().x, getPosition().y, batch);
    }

    public void toggle() {
        this.isOn = !this.isOn;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}

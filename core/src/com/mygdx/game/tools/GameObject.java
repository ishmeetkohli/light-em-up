/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.mygdx.game.tools;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class GameObject {
    private Vector2 position;
    private Rectangle bounds;

    public float stateTime = 0;

    public GameObject(float x, float y, float width, float height) {
        this.position = new Vector2();
        this.bounds = new Rectangle();
        create(x, y, width, height);
    }

    public GameObject() {
        this.position = new Vector2();
        this.bounds = new Rectangle();
    }

    public void create(float x, float y, float width, float height) {
        this.position.set(x, y);
        this.bounds.set(x - width / 2, y - height / 2, width, height);
    }

    public void update(float deltaTime) {
        stateTime += deltaTime;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector2 getPosition() {
        return position;
    }
}

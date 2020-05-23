package com.dune.game.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Projectile {
    private Vector2 position;
    private Vector2 velocity;
    private boolean visible;
    private TextureRegion textures;

    public Projectile(TextureAtlas atlas) {
        this.textures = (atlas.findRegion("bullet"));
        this.visible = false;
        this.position = new Vector2();
        this.velocity = new Vector2();
    }

    public void setup(Vector2 startPosition, float angle) {
        velocity.set(100.0f * MathUtils.cosDeg(angle), 0.0f);
        visible = true;
    }

    public void update(float dt) {
        // position.x += velocity.x * dt;
        // position.y += velocity.y * dt;
        position.mulAdd(velocity, dt);
        if (position.x < 0) {
            visible = false;
        }
        if (position.y < 0) {
            visible = false;
        }
        if (position.x > 1280) {
            visible = false;
        }
        if (position.y > 720) {
            visible = false;
        }
    }
    public void render(SpriteBatch batch) {
        batch.draw(textures, 0, 0, 0, 0, 20, 20, 1, 1,0);
    }
}
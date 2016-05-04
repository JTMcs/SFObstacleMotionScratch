package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class Obstacles extends ApplicationAdapter {
    SpriteBatch sbPic;
    Texture txrSpike;
    Array<Sprite> sprSpike;
    int nVelo;
    float fX, fY;

    @Override
    public void create() {
        sbPic = new SpriteBatch();
        txrSpike = new Texture("spikeball.png");
        fY = Gdx.graphics.getHeight() / 2;
        sprSpike = new Array<Sprite>(false, 5);
        for (int i = 0; i < 5; i++) {
            sprSpike.add(new Sprite(txrSpike, 0, 0, 128, 128));
            sprSpike.get(i).setSize(Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);
            fX = i * (Gdx.graphics.getWidth() + txrSpike.getWidth()) / 5;
            sprSpike.get(i).setPosition(fX, fY);
            //nVelo = (int) Math.floor(Math.random() * 5);
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sbPic.begin();
        for (int i = 0; i < 5; i++) {
            sprSpike.get(i).draw(sbPic);
            sprSpike.get(i).translateX(3);
            if (sprSpike.get(i).getX() > Gdx.graphics.getWidth()) {
                sprSpike.get(i).setX(-txrSpike.getWidth());
            }
        }
        sbPic.end();
    }
}

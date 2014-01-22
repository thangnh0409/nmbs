package com.shinkansen.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Number extends GameObject {

	private float actorX;
	private float actorY;
	private boolean touched = false;
	private final int value;
	
	public Number(float actorX, float actorY, int value) {
		this.actorX = actorX;
		this.actorY = actorY;
		this.value = value;
		texture = new Texture(Gdx.files.internal("data/1.png"));
		txtWidth = texture.getWidth();
		txtHeight = texture.getHeight();
		txtScale = 0.3f;
		region = new TextureRegion(texture);
		
		setBounds(actorX, actorY, txtWidth, txtHeight);
		addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				((Number)event.getTarget()).touched = true;
				System.out.println("Touch down at number "+ Number.this.value);
				return true;
			}
		});
	}
	@Override
    public void draw(Batch batch, float alpha){
        batch.draw(region, actorX, actorY, txtWidth/2,
				txtHeight/2, txtWidth,txtHeight, txtScale, txtScale, 45f, false);
    }
    
    @Override
    public void act(float delta){
    	if (actorX > Gdx.graphics.getWidth()) touched = false;
    	
        if(touched){
            actorX+=5;
        }
    }

}

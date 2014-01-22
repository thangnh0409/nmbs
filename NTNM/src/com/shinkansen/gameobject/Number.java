package com.shinkansen.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import com.shinkansen.gameasset.Assets;

public class Number extends GameObject {

	private float actorX;
	private float actorY;
	private boolean touched = false;
	private final int value;
	
	public Number(float actorX, float actorY, int value) {
		this.actorX = actorX;
		this.actorY = actorY;
		this.value = value;
		txtWidth = Assets.ttNumber.getWidth();
		txtHeight = Assets.ttNumber.getHeight();
		txtScale = 1f;
		setPosition(actorX, actorY);
		
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
		//System.out.println("call draw actor");
        batch.draw(Assets.rgNumber, getX(), getY(), txtWidth/2,
				txtHeight/2, txtWidth,txtHeight, txtScale, txtScale, 45f, false);
    }
    
    @Override
    public void act(float delta){
    	super.act(delta);
    	if (actorX > Gdx.graphics.getWidth()) touched = false;
    	
        if(touched){
            addAction(moveTo( Containers.actorX - Assets.ttContainer.getWidth()/2,
            		Containers.actorY - Assets.ttContainer.getHeight()/2, 0.5f, Interpolation.bounceOut));
        }
        updateBounds();
    }
    
    private void updateBounds() {
    	  setBounds(getX(), getY(), getWidth(), getHeight());
    } 

}

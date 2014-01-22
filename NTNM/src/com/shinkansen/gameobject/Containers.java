package com.shinkansen.gameobject;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.shinkansen.gameasset.Assets;

public class Containers extends GameObject {
	public static float actorX;
	public static float actorY;

	public Containers(float actorX1, float actorY1) {
		actorX = actorX1;
		actorY = actorY1;
		txtWidth = Assets.ttContainer.getWidth();
		txtHeight = Assets.ttContainer.getHeight();
		txtScale = 1.0f;
	}
	@Override
    public void draw(Batch batch, float alpha){
		//System.out.println("call draw actor");
        batch.draw(Assets.rgContainer, actorX, actorY, txtWidth,txtHeight);
    }
    
    @Override
    public void act(float delta){
    	super.act(delta);
    }
}

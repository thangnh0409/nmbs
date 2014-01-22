package com.shinkansen.gameasset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static Texture textureActor;
	public static TextureRegion regionActor;
	public static Texture ttNumber;
	public static TextureRegion rgNumber;
	public static Texture ttContainer;
	public static TextureRegion rgContainer; 
	
	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}
	public static void load(){
		ttNumber = loadTexture("data/1.png");
		rgNumber = new TextureRegion(ttNumber);
		ttContainer = loadTexture("data/trash_empty.png");
		rgContainer = new TextureRegion(ttContainer);
	}

}

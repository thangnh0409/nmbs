package com.shinkansen.mygdxgame;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.transform.Templates;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.shinkansen.gameobject.Number;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private Stage stage;
	TextureRegion region;
	
	private int arr[][];
	private ArrayList<Integer> arrRandNum;
	
	static final int COLUMN = 6;
	static final int ROW = 6;
	static final int CELL_WIDTH = 60;
	static final int CELL_HEIGHT = 60;
	static final int ROOT_X = 40;
	static final int ROOT_Y = 40;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		// init array random number
		
		arr = new int[ROW][COLUMN];
		arrRandNum = new ArrayList<Integer>();
		randomNumber();
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		addActorToStage();
		texture = new Texture(Gdx.files.internal("data/1.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		region = new TextureRegion(texture);
		
		
	}
	public void randomNumber(){
		boolean dd = false;
		int randNum;
		Random rand = new Random();
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				while (true) {
					randNum = rand.nextInt(ROW*COLUMN);
					dd = false;
					for (int j2 = 0; j2 < arrRandNum.size(); j2++) {
						if (randNum == arrRandNum.get(j2)) {
							dd = true;
							break;
						}
					}
					if (!dd) {
						arr[i][j] = randNum;
						arrRandNum.add(randNum);
						System.out.println("arr["+i +","+j+"] = " + randNum);
						break;
					}
				}
			}
		}
	}
	public void addActorToStage(){
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				Number numberActor = new Number(i * CELL_WIDTH + ROOT_X,
						j * CELL_HEIGHT + ROOT_Y, arr[i][j]);
				numberActor.setTouchable(Touchable.enabled);
				stage.addActor(numberActor);
			}
		}
		
	}
	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}

package cs.binghamton.edu;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Bomberman extends Game {
	public SpriteBatch batch; //to give access to screens

	//world parameters for height and width
	public static final int WORLD_HEIGHT = 300;
	public static final int WORLD_WIDTH = 270;

	//pixels per meter
	//public static final float PPM = 100;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		//use the screen classes' render method
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		
	}
}

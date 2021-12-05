package cs.binghamton.edu;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Bomberman extends Game {
	public SpriteBatch batch; //to give access to screens

	
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

package cs.binghamton.edu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    private Bomberman game;
    Texture texture;

    public GameScreen(Bomberman game){
        this.game = game;
        texture = new Texture("badlogic.jpg");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //to clear screen
        ScreenUtils.clear(1, 0, 0, 1);

        game.batch.begin();
        game.batch.draw(texture,0,0);
        game.batch.end();

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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

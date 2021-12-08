package cs.binghamton.edu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {
    //game object to set screen on Bomberman.java class
    private Bomberman game;

    //game camera
    private OrthographicCamera gameCam;

    //game viewport
    private Viewport gamePort;

    //hud
    private Hud hud;


    public GameScreen(Bomberman game){
        this.game = game;
        gameCam = new OrthographicCamera();

        //to protect ratio for any screen size
        gamePort = new FitViewport(Bomberman.WORLD_WIDTH,Bomberman.WORLD_HEIGHT,gameCam);

        hud = new Hud(game.batch);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //to clear screen
        ScreenUtils.clear(1, 0, 0, 1);

        //game.batch.begin();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        //game.batch.end();

    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);

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

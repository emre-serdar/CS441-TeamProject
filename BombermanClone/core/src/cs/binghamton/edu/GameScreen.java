package cs.binghamton.edu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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

    //to load map which we have created to the screen
    private TmxMapLoader mapLoader;

    //reference to do map
    private TiledMap map;

    //to render our map to the screen
    private OrthogonalTiledMapRenderer renderer;


    public GameScreen(Bomberman game){
        this.game = game;
        gameCam = new OrthographicCamera();

        //to protect ratio for any screen size
        gamePort = new StretchViewport(Bomberman.WORLD_WIDTH,Bomberman.WORLD_HEIGHT,gameCam);

        hud = new Hud(game.batch);
        mapLoader = new TmxMapLoader();

        //loading map
        map = mapLoader.load("map.tmx");

        //rendering map
        renderer = new OrthogonalTiledMapRenderer(map);

        //
        gameCam.position.set(118,125,0);

    }

    public void handleInput(float delta){
        if (Gdx.input.isTouched()) {
            gameCam.position.x += 100 * delta;
            gameCam.position.y += 100 *delta;
        }
    }

    public void update(float delta){
        handleInput(delta);

        //update game cam every iteration of render cycle
        gameCam.update();

        //render only what gameCam can see
        renderer.setView(gameCam);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //update
        update(delta);

        //to clear screen
        ScreenUtils.clear(0, 0, 0, 0);
        renderer.render();

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

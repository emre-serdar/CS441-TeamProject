package cs.binghamton.edu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
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

    //world and Box2d
    private World world;
    private Box2DDebugRenderer debugRenderer;



    //
    private Texture texture;

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

        //creating the world with 0,0 gravity
        world = new World(new Vector2(0,0), true);
        debugRenderer = new Box2DDebugRenderer();

        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        //create a body and fixture for every corresponding object
        //breakable blocks
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle objectBody = ((RectangleMapObject) object).getRectangle();

            //dynamic body for blocks in the map
            bodyDef.type = BodyDef.BodyType.DynamicBody;
            bodyDef.position.set(objectBody.getX() + objectBody.getWidth()/2, objectBody.getY() + objectBody.getHeight()/2);
            body = world.createBody(bodyDef);

            shape.setAsBox(objectBody.getWidth()/2, objectBody.getHeight()/2 );
            fixtureDef.shape = shape;
            body.createFixture(fixtureDef);

        }
        // unbreakable
        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle objectBody = ((RectangleMapObject) object).getRectangle();


            bodyDef.type = BodyDef.BodyType.DynamicBody;
            bodyDef.position.set(objectBody.getX() + objectBody.getWidth()/2, objectBody.getY() + objectBody.getHeight()/2);
            body = world.createBody(bodyDef);

            shape.setAsBox(objectBody.getWidth()/2, objectBody.getHeight()/2 );
            fixtureDef.shape = shape;
            body.createFixture(fixtureDef);

        }


        //texture = new Texture("tile218.png");

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

        //to render map
        renderer.render();

        //box2D renderer
        debugRenderer.render(world, gameCam.combined);

        //game.batch.begin();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();



        //game.batch.begin();
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

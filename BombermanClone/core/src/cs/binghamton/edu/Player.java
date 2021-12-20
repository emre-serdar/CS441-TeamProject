package cs.binghamton.edu;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class Player extends Sprite {

    //world
    public World world;
    public Body b2body;
    private TextureRegion playerStand;
    public enum State {UP,DOWN,RIGHT, LEFT, STANDING};
    public State currentState;
    public State previousState;

    //animation
    private Animation playerRun;
    private float stateTimer;
    private boolean runningRight;




    //player features
    float movementSpeed;

    //bomb features
    float timeBetweenFires;
    float timeSinceLastFire = 0; //starts with zero

    //graphics
    TextureRegion playerTextureRegion, bombTextureRegion;

    //position
    Rectangle boundingBox;

    public Player(World world, GameScreen screen){
        super(screen.getAtlas().findRegion("up1"));
        this.world = world;
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer =0;
        definePlayer();

        Array<TextureRegion> frames = new Array<TextureRegion>();

    }
    public void update(float delta){
        setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y - getHeight()/2 );
    }

    public void definePlayer(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(22,22);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5);


        fdef.shape = shape;

        b2body.createFixture(fdef);


    }

}





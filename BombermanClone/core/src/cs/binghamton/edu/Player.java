package cs.binghamton.edu;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    //player features
    float movementSpeed;

    //bomb features
    float timeBetweenFires;
    float timeSinceLastFire = 0; //starts with zero

    //graphics
    TextureRegion playerTextureRegion, bombTextureRegion;

    //position
    Rectangle boundingBox;

    public Player(float xPos, float yPos){

    }

    //

    public boolean intersects(Rectangle rectangle1){
        return boundingBox.overlaps(rectangle1);
    }

}

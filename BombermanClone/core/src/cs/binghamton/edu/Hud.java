package cs.binghamton.edu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Hud {
    public Stage stage;
    private Viewport viewport;
    private Integer timer;
    //private Integer score;
    private Integer healthPoints;

    Label countDown;
    Label hp;
    Label countDownLabel;
    Label hpLabel;


    Hud(SpriteBatch spriteBatch){
        timer = 150;
        //score = 0;

        healthPoints = 100;

        viewport = new FitViewport(Bomberman.WORLD_WIDTH,Bomberman.WORLD_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, spriteBatch);

        //defining a table for labels
        Table table = new Table();

        //putting table to top of the screen
        table.top();
        table.setFillParent(true);

        //creating labels
        countDown = new Label(String.format("%03d", timer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        hp =  new Label(String.format("%03d", healthPoints), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        hpLabel = new Label("HEALTH:", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        countDownLabel = new Label("TIME:", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        //inserting labels to table
        table.add(hpLabel).expandX().padLeft(20);
        table.add(hp).expandX().padLeft(-20);
        table.add(countDownLabel).expandX().padRight(20);
        table.add(countDown).expandX().padLeft(-70);
        table.padTop(10);




        stage.addActor(table);
    }
}

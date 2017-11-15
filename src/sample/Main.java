package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    World world = new World();

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("My World");
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        Canvas canvas = new Canvas(800,600);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        world.addActor(new Actor(100,100,"images/actor.png"));
        world.addActor(new Actor(100,200,"images/actor.png"));
        world.addActor(new Actor(400,100,"images/actor.png"));
        world.addActor(new Actor(200,500,"images/actor.png"));
        world.addActor(new Bug(300,200));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setFill(Color.WHITE);
                gc.fillRect(0,0,800,600);
                world.step();
                world.draw(gc);
            }
        }.start();

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

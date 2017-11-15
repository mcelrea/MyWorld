package sample;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class World {
    ArrayList<Actor> actors;
    private long tickRate = 500; //100 ms = 1/10 second
    private long nextUpdate;

    public World() {
        //creates an empty list
        actors = new ArrayList<Actor>();
        nextUpdate = System.currentTimeMillis()+tickRate;//current time
    }

    public void addActor(Actor a) {
        actors.add(a);
    }

    public void step() {
        if(System.currentTimeMillis() > nextUpdate) {
            for (int i = 0; i < actors.size(); i++) {
                Actor current = actors.get(i);
                current.act();
            }
            nextUpdate = System.currentTimeMillis()+tickRate;
        }
    }

    public void draw(GraphicsContext gc) {
        for(int i=0; i < actors.size(); i++) {
            Actor current = actors.get(i);
            current.draw(gc);
        }
    }
}

package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileInputStream;

public class Actor {
    private Location myLoc;
    private Image northImage, northEastImage, eastImage,
                  southEastImage, southImage, southWestImage,
                  westImage, northWestImage;
    private int myDir = Location.NORTH;

    public Actor(double x, double y, String imagePath) {
        myLoc = new Location(x,y);


        File file = new File(imagePath);
        try {
            northImage = new Image(new FileInputStream(file));
        } catch (Exception e) {
            //if it errors
            System.out.println("COULD NOT LOAD ACTOR IMAGE");
            e.printStackTrace();
        }

        ImageView iv = new ImageView(northImage);
        iv.setRotate(45);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        northEastImage = iv.snapshot(params, null);

        iv.setRotate(90);
        eastImage = iv.snapshot(params, null);

        iv.setRotate(135);
        southEastImage = iv.snapshot(params, null);

        iv.setRotate(180);
        southImage = iv.snapshot(params, null);

        iv.setRotate(225);
        southWestImage = iv.snapshot(params, null);

        iv.setRotate(270);
        westImage = iv.snapshot(params, null);

        iv.setRotate(315);
        northWestImage = iv.snapshot(params, null);
    }

    public void draw(GraphicsContext gc) {
        if(myDir == Location.NORTH)
            gc.drawImage(northImage,myLoc.getX(),myLoc.getY());
        else if(myDir == Location.NORTHEAST)
            gc.drawImage(northEastImage,myLoc.getX(),myLoc.getY());
        else if(myDir == Location.EAST)
            gc.drawImage(eastImage,myLoc.getX(),myLoc.getY());
        else if(myDir == Location.SOUTHEAST)
            gc.drawImage(southEastImage,myLoc.getX(),myLoc.getY());
        else if(myDir == Location.SOUTH)
            gc.drawImage(southImage,myLoc.getX(),myLoc.getY());
        else if(myDir == Location.SOUTHWEST)
            gc.drawImage(southWestImage,myLoc.getX(),myLoc.getY());
        else if(myDir == Location.WEST)
            gc.drawImage(westImage,myLoc.getX(),myLoc.getY());
        else if(myDir == Location.NORTHWEST)
            gc.drawImage(northWestImage,myLoc.getX(),myLoc.getY());
    }

    public void act() {
        myDir = (myDir+1)%8;
    }

    public void setX(double x) {
        myLoc.setX(x);
    }

    public void setY(double y) {
        myLoc.setY(y);
    }

    public void setMyLoc(double x, double y) {
        myLoc.setX(x);
        myLoc.setY(y);
    }

    public Location getMyLoc() {
        return myLoc;
    }

    public int getMyDir() {
        return myDir;
    }

    public void setMyDir(int myDir) {
        this.myDir = myDir;
    }
}

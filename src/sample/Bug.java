package sample;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

public class Bug extends Actor {

    private double speed = 40;

    public Bug(double x, double y) {
        super(x,y,"images/boxBug.png");
    }

    @Override
    public void act() {
        if(getMyDir() == Location.NORTH) {
            setY(getMyLoc().getY()-speed);

            //if I went off the top of the screen
            if(getMyLoc().getY() <= 0) {
                setY(0); //put back on screen
                setMyDir(Location.EAST); //turn 90 degrees
            }
        }//end if facing NORTH
        else if(getMyDir() == Location.EAST) {
            setX(getMyLoc().getX()+speed);

            //if I went off the right side of the screen
            if(getMyLoc().getX() > 779) {
                setX(779);//put back on screen
                setMyDir(Location.SOUTH);//turn 90 degrees
            }
        }//end else if facing EAST
        else if(getMyDir() == Location.SOUTH) {
            setY(getMyLoc().getY()+speed);

            //if I went off the bottom screen
            if(getMyLoc().getY() > 579) {
                setY(579);//put back on screen
                setMyDir(Location.WEST);//turn 90 degrees
            }
        }//end else if facing SOUTH
        else if(getMyDir() == Location.WEST) {
            setX(getMyLoc().getX()-speed);

            //if I went off left side of the screen
            if(getMyLoc().getX() < 0) {
                setX(0);
                setMyDir(Location.NORTH);
            }
        }//end else if facing WEST
    }
}

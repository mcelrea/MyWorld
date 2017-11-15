package sample;

public class Location {
    private double x;
    private double y;
    public static final int NORTH=0;
    public static final int NORTHEAST=1;
    public static final int EAST=2;
    public static final int SOUTHEAST=3;
    public static final int SOUTH=4;
    public static final int SOUTHWEST=5;
    public static final int WEST=6;
    public static final int NORTHWEST=7;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

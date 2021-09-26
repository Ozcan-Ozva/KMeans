package Component;

public class Point {
    public int latitude;
    public int longitude;
    public int distanceFromNearestCluster;
    public boolean check;
    public int clusterId;


    public Point(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.distanceFromNearestCluster = Integer.MAX_VALUE;
        check = false;
        clusterId = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return "Point{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", distanceFromNearestCluster=" + distanceFromNearestCluster +
                ", check=" + check +
                ", clusterId=" + clusterId +
                '}' + "\n";
    }
}

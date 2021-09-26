package Component;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
    public static int id = 0;
    public int latitude;
    public int longitude;
    public List<Point> points;

    public Cluster(int latitude, int longitude) {
        id++;
        this.latitude = latitude;
        this.longitude = longitude;
        points = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Cluster{" +
                "latitude=" + latitude +
                ", longitude=" + longitude + "\n" +
                ", points=" + points +
                '}';
    }
}

import Component.Cluster;
import Component.Point;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(5,4));
        points.add(new Point(18,16));
        points.add(new Point(83,78));
        points.add(new Point(25,20));
        points.add(new Point(85,74));
        points.add(new Point(16,14));
        points.add(new Point(95,94));
        points.add(new Point(12,8));

        Algorithm algorithm = new Algorithm(points);
        List<Cluster> clusters = algorithm.runAlgorithm();

        System.out.println(clusters.size());

        for (Cluster cluster: clusters
             ) {
            System.out.println(cluster);
        }

    }
}

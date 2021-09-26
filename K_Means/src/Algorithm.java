import Component.Cluster;
import Component.Point;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    List<Point> points;
    final int DISTANCE = 20;

    public Algorithm(List<Point> points) {
        this.points = points;
    }

    public List<Cluster> runAlgorithm() {
        List<Cluster> clusters = new ArrayList<>();

        while (!isAllStudentIsChecked()) {
            for (int i = 0; i < this.points.size(); i++) {
                if (!points.get(i).check) {
                    Cluster cluster = new Cluster(points.get(i).latitude, points.get(i).longitude);
                    clusters.add(cluster);
                    for (int j = 0; j < points.size(); j++) {
                        if (isPointCanAddedToCluster(cluster, points.get(j), clusters)) {
                            cluster.points.add(points.get(j));
                            points.get(j).check = true;
                            points.get(j).clusterId = Cluster.id;
                            points.get(j).distanceFromNearestCluster = distanceBetween(cluster, points.get(j));
                            for (Cluster cluster1: clusters
                                 ) {
                                changeClusterPosition(cluster1);
                            }
                            System.out.println();
                            j = 0;
                        }
                        System.out.println(cluster);
                        System.out.println();
                    }
                }
            }
        }
        return clusters;
    }

    private boolean isAllStudentIsChecked(){
        int counter = 0;
        for (Point point: points
             ) {
            if (point.check) counter++;
        }
        return counter == points.size();
    }

    private boolean isPointCanAddedToCluster(Cluster cluster ,Point point, List<Cluster> clusters) {
        return distanceBetween(cluster, point) <= DISTANCE
                && !isPointIsAlreadyExistInCluster(cluster, point) && !isCheck(cluster, point, clusters);
    }

    private int distanceBetween(Cluster cluster, Point point) {
        return (int) Math.sqrt(Math.pow((cluster.latitude - point.latitude), 2) + Math.pow((cluster.longitude - point.longitude), 2));
    }

    private boolean isCheck(Cluster cluster, Point point, List<Cluster> clusters) {
        if (!point.check) return false;
        else {
            if (distanceBetween(cluster,point) < point.distanceFromNearestCluster) {
                clusters.get(point.clusterId -1).points.remove(point);
                return false;
            }else return true;
        }
    }

    private boolean isPointIsAlreadyExistInCluster(Cluster cluster, Point point) {
        return cluster.points.contains(point);
    }

    private void changeClusterPosition(Cluster cluster) {
        int centroidX = 0;
        int centroidY = 0;
        for (Point point: cluster.points
             ) {
            centroidY += point.latitude;
            centroidX += point.longitude;
        }
        cluster.latitude = centroidY / cluster.points.size();
        cluster.longitude = centroidX / cluster.points.size();
        System.out.println("this is new " + cluster.latitude + " " + cluster.longitude);
        changePointDistance(cluster);
    }

    private void changePointDistance(Cluster cluster) {
        for (Point point: cluster.points
             ) {
            point.distanceFromNearestCluster = distanceBetween(cluster,point);
        }
    }
}

public class Triangle extends Point {
    private double pitch;
    private double roll;
    private double yaw;
    // lines visible
    private boolean l1Vis;
    private boolean l2Vis;
    private boolean l3Vis;
    private Point[] points;

    public Triangle(Point one, Point two, Point three) {
        points = new Point[]{one, two, three};
        pitch = 0;
        roll = 0;
        yaw = 0;
    }

    public Triangle(double p1x, double p1y, double p1z, double p2x, double p2y, double p2z, double p3x, double p3y, double p3z) {
        this(new Point(p1x, p1y, p1z), new Point(p2x, p2y, p2z), new Point(p3x, p3y, p3z));
    }
}

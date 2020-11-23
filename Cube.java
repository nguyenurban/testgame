

public class Cube extends Point {
   private Point[] points;
   
   public Cube(double pos, double xLength, double yLength, double zLength) {
      Point[] points = new Point[8];
      points[0] = new Point(pos - xLength / 2, pos - yLength / 2, pos - zLength / 2);
      points[1] = new Point(pos + xLength / 2, pos - yLength / 2, pos - zLength / 2);
      points[2] = new Point(pos - xLength / 2, pos + yLength / 2, pos - zLength / 2);
      points[3] = new Point(pos - xLength / 2, pos - yLength / 2, pos + zLength / 2);
      points[4] = new Point(pos + xLength / 2, pos + yLength / 2, pos - zLength / 2);
      points[5] = new Point(pos + xLength / 2, pos - yLength / 2, pos + zLength / 2);
      points[6] = new Point(pos - xLength / 2, pos + yLength / 2, pos + zLength / 2);
      points[7] = new Point(pos + xLength / 2, pos + yLength / 2, pos + zLength / 2);
      Triangle[] triangles = new Triangle[12];
      triangles[0] = new Triangle(points[0], points[3], points[1]);
   }
   
  public Cube(double pos, double length) {
      this(pos, length, length, length);
   }
   
   public void translate(double right, double forward, double up) {
      for (Point curr : points) {
         curr.setX(curr.getX() + right);
         curr.setY(curr.getY() + forward);
         curr.setZ(curr.getZ() + up);
      }
   }
   
   public void rotate(double pitch, double roll, double yaw) {
     pitch = Math.toRadians(pitch);
     roll = Math.toRadians(roll);
     yaw = Math.toRadians(yaw);
     double cosPitch = Math.cos(pitch);
     double sinPitch = Math.sin(pitch);
     double cosRoll = Math.cos(roll);
     double sinRoll = Math.sin(roll);
     double cosYaw = Math.cos(yaw);
     double sinYaw = Math.sin(yaw);
      for (Point curr : points) {
         curr.setX(cosYaw * cosRoll * curr.getX() +
            (cosYaw * sinRoll * sinPitch - sinYaw * cosPitch) * curr.getY() +
            (cosYaw * sinRoll * cosPitch + sinYaw * sinPitch) * curr.getZ());
         curr.setY(cosYaw * cosRoll * curr.getX() +
            (sinYaw * sinRoll * sinPitch + cosYaw * cosPitch) * curr.getY() +
            (sinYaw * sinRoll * cosPitch - cosYaw * sinPitch) * curr.getZ());
         curr.setZ(-sinRoll * curr.getX() +
            cosRoll * sinPitch * curr.getY() +
            cosPitch * cosPitch * curr.getZ());
      }
   }

   public void draw() {}
}
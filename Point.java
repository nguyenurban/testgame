public class Point {
   private double x;
   private double y;
   private double z;
   private double pitch;
   private double roll;
   private double yaw;
   public boolean visible = true;

   public Point(double x, double y, double z, double pitch, double roll, double yaw) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.pitch = pitch;
      this.roll = roll;
      this.yaw = yaw;
   }
   
   public Point(double x, double y, double z) {
      this(x, y, z, 0, 0, 0);
   }
   
   public Point() {
      this(0, 0, 0, 0, 0, 0);
   }
   
   public void translate(double right, double forward, double up) {
      x += right;
      y += forward;
      z  += up;
   }
   public void rotate(double pitch, double roll, double yaw) {
      this.pitch += pitch;
      this.roll += roll;
      this.yaw += yaw;
   }

   public void isVisible(boolean visible) {
      this.visible = visible;
   }
  
   public double getX() {
      return x;
   }
   
   public double getY() {
      return y;
   }
   
   public double getZ() {
      return z;
   }
   
   public void setX(double in) {
      x = in;
   }
   
   public void setY(double in) {
      y = in;
   }
   
   public void setZ(double in) {
      z = in;
   }
   
   public double getPitch() {
      return pitch;
   }
   
   public double getRoll() {
      return roll;
   }
   
   public double getYaw() {
      return yaw;
   }
   
   public void setPitch(double in) {
      pitch = in;
   }
   
   public void setRoll(double in) {
      roll = in;
   }
   
   public void setYaw(double in) {
      yaw = in;
   }

   public void draw() {}
}
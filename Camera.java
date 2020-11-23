public class Camera extends Point {
   
   private Space cameraSpace;
   private double fovWidth = 1920;
   private double fovAspectRatio = 16d / 9d;
   private double fov = 90.0d;
   private double fovRad = 1.0d / Math.tan(fov * 0.5 / 180.0 * Math.PI);
   private double near = 0.1d;
   private double far = 1000.0d;
   private double q = far / (far - near);
   // columns rows, then columns
   private double[][] projMatrix = {{fovAspectRatio * fovRad, 0, 0, 0}, {0, fovRad, 0, 0}, {0, 0, q, 1}, {0, -near * q, 1, 0}};
   
   public Camera(double x, double y, double z, double pitch, double roll, double yaw) {
      super(x, y, z, pitch, roll, yaw);
   }
   
   public Camera() {
      this(0, 0, 0, 0, 0, 0);
   }

   public void cameraTransform(Point in) {
      double[][] output = multiplyMatrix(projMatrix, new double[][] {{in.getX()}, {in.getY()}, {in.getZ()}, {1}});
      in.setX(output[0][0] / output[3][0]);
      in.setY(output[1][0] / output[3][0]);
      in.setZ(output[2][0] / output[3][0]);
   }

   private double[][] multiplyMatrix(double[][] one, double[][] two) {
      double[][] out = new double[two.length][two[0].length];
      for (int i = 0; i < two[0].length; i++) {
         for (int j = 0; j < two.length; j++) {
            int sum = 0;
            for (int k = 0; k < one[0].length; k++) {
               sum += one[j][k] * two[k][i];
            }
            out[j][i] = sum;
         }
      }
      return out;
   }
}
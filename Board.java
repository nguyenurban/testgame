import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Board extends JPanel implements Runnable {

   private Image beter;
   private Thread drawFrame;
   double startDeg = 0;
   double circlePos = 0;
   private Space area;
   private Camera mainCam;
   private Point[] objects;
   public Board() {
      ImageIcon ii = new ImageIcon("beter.jpg");
      beter = ii.getImage();
      setPreferredSize(new Dimension(beter.getWidth(this), beter.getHeight(this)));
      area = new Space();
      mainCam = new Camera();
   }
   public void paintComponent(Graphics g) {
      g.drawImage(beter, 0, 0, null);
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      drawDonut(g2d);
      // drawSquare(g2d);
   }
   
   private void drawSquare(Graphics2D g2d) {
      
   }

   private void drawDonut(Graphics2D g2d) {

      RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

      rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

      g2d.setRenderingHints(rh);

      Dimension size = getSize();
      double w = size.getWidth();
      double h = size.getHeight();
      double orbitRadius = w / 4;

      Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
      g2d.setStroke(new BasicStroke(1));
      g2d.setColor(Color.cyan);
      for (double deg = startDeg; deg < startDeg + 360; deg += 360 / 45) {
         AffineTransform at
                    = AffineTransform.getTranslateInstance(w/2 + orbitRadius * Math.cos(circlePos), h/2 + orbitRadius * Math.sin(circlePos));
         at.rotate(Math.toRadians(deg));
         g2d.draw(at.createTransformedShape(e));
      }
      mainCam = new Camera();
   }
   
   private void useCamera() {
      for (Point object : objects) {
         mainCam.cameraTransform(object);
      }
   }

   public void addNotify() {
      super.addNotify();
      drawFrame = new Thread(this);
      drawFrame.start();
   }
   public void update() {
      startDeg += 1.75;
      circlePos -= 0.1 / (2 * Math.PI);
      // useCamera();
   }
   
   public void run() {
      long start, timer, cooldown;
      long maxCooldown = 25;
      start = System.currentTimeMillis();
      while (true) {
         update();
         repaint();
         timer = System.currentTimeMillis() - start;
         cooldown = maxCooldown - timer;
         if (cooldown < 0) {
            cooldown = 2;
         }
         try {
           Thread.sleep(cooldown);
         } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(this, "Thread interrupted", "Error", JOptionPane.ERROR_MESSAGE);
         }
         start = System.currentTimeMillis();
      }
   }
}
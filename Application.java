import java.awt.*;
import javax.swing.*;

public class Application extends JFrame {
    public Board b;
    
    public Application() {
        initUI();
    }

    private void initUI() {
      b = new Board();
        add(b);
        pack();
        setSize(500, 500);
        setTitle("how do i program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {     
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
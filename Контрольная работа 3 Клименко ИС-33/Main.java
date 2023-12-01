import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args){
        WelcomeFrame welcomeFrame = new WelcomeFrame();
        welcomeFrame.pack();
        welcomeFrame.setSize(new Dimension(800, 200));
        welcomeFrame.setVisible(true);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLocationRelativeTo(null);
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame {
    private JPanel welpanel;
    private JButton OKbutton;
    private JButton screamerButton;

    public WelcomeFrame() {
        this.getContentPane().add(welpanel);

        OKbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mf = new MainFrame();
                dispose();
                mf.setVisible(true);
                mf.setSize(400, 400);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setLocationRelativeTo(null);
            }
        });

        screamerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
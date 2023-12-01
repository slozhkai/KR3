import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class CatsFrame extends JFrame{
    private JList<String> listCat;
    private Map<String, ImageIcon> imageMap;

    public CatsFrame(){
        setTitle("Коты");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        String[] data = {"Кот на дереве", "Злой кот", "Кот добрый", "Котенок проснулся", "Котик няшиться", "Кот краб", "Крутой кот", "НЕ ОТКРЫВАТЬ", "Рыжий кот", "Dance-cat"
                , "Собака и кот", "Когда ударил ******", "WTF кот", "Аллилуя кот", "Задумчивый кот"};
        listCat = new JList<>(data);

        loadImage();

        listCat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (e.getClickCount() == 1) {
                    displayImage();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(listCat);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void loadImage() {
        imageMap = new HashMap<>();

        imageMap.put("Кот на дереве", new ImageIcon("img/кот1.jpg"));
        imageMap.put("Злой кот", new ImageIcon("img/кот2.jpg"));
        imageMap.put("Кот добрый", new ImageIcon("img/кот3.jpg"));
        imageMap.put("Котенок проснулся", new ImageIcon("img/кот4.jpg"));
        imageMap.put("Котик няшиться", new ImageIcon("img/кот5.jpg"));
        imageMap.put("Кот краб", new ImageIcon("img/кот6.jpg"));
        imageMap.put("Крутой кот", new ImageIcon("img/кот7.jpg"));
        imageMap.put("НЕ ОТКРЫВАТЬ", new ImageIcon("img/кот8.jpg"));
        imageMap.put("Рыжий кот", new ImageIcon("img/кот9.jpg"));
        imageMap.put("Dance-cat", new ImageIcon("img/кот10.jpg"));
        imageMap.put("Собака и кот", new ImageIcon("img/кот11.jpg"));
        imageMap.put("Когда ударил ******", new ImageIcon("img/кот12.jpg"));
        imageMap.put("WTF кот", new ImageIcon("img/кот13.jpg"));
        imageMap.put("Аллилуя кот", new ImageIcon("img/кот14.jpg"));
        imageMap.put("Задумчивый кот", new ImageIcon("img/кот15.jpg"));
    }

    private void displayImage(){
        String selectedValue = listCat.getSelectedValue();
        ImageIcon imageIcon = imageMap.get(selectedValue);

        if(imageIcon != null) {
            JFrame imageFrame = new JFrame("Картинка");
            imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel label = new JLabel(imageIcon);
            imageFrame.getContentPane().add(label);
            imageFrame.pack();
            imageFrame.setVisible(true);
            imageFrame.setLocationRelativeTo(null);
        }
    }
}

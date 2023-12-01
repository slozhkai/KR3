import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private JPanel panel;
    private JButton buttonStable;
    private JButton buttonStall;
    private JButton buttonHorses;
    private JButton buttonEmployees;
    private JButton buttonResults;
    private JButton catsButton;
    private JButton deleteButton;


    private String konushnyaName, konushnyaAddress;
    private int numOfHorses, numOfStalls, numOfWaterbowls;
    private boolean heatingInStalls;
    private List<MainFrame.Horse> horses;
    private List<MainFrame.Employee> employees;


    public MainFrame() {
        this.getContentPane().add(panel);

        buttonStable.setEnabled(true);
        buttonStall.setEnabled(false);
        buttonHorses.setEnabled(false);
        buttonEmployees.setEnabled(false);
        buttonResults.setEnabled(false);
        deleteButton.setEnabled(false);
        catsButton.setEnabled(true);


        buttonStable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStableDialog();

                buttonStable.setEnabled(false);
                buttonStall.setEnabled(true);
            }
        });

        buttonStall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStallDialog();

                buttonStall.setEnabled(false);
                buttonHorses.setEnabled(true);
            }
        });

        buttonHorses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHorsesDialog();

                buttonHorses.setEnabled(false);
                if (numOfStalls > 0) {
                    buttonEmployees.setEnabled(true);
                }
            }
        });

        buttonEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEmployeesDialog();

                buttonEmployees.setEnabled(false);
                buttonResults.setEnabled(true);
            }
        });

        buttonResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showResultsDialog();

                buttonEmployees.setEnabled(false);
                buttonResults.setEnabled(true);
                deleteButton.setEnabled(true);
            }
        });

        catsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CatsFrame catsFrame = new CatsFrame();
                catsFrame.setVisible(true);
                catsFrame.setSize(400, 300);
                catsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                catsFrame.setLocationRelativeTo(null);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetData();
            }
        });
    }

    private void resetData() {
        konushnyaName = null;
        konushnyaAddress = null;
        numOfHorses = 0;
        numOfStalls = 0;
        numOfWaterbowls = 0;
        heatingInStalls = false;
        horses = null;
        employees = null;

        buttonStable.setEnabled(true);
        buttonStall.setEnabled(false);
        buttonHorses.setEnabled(false);
        buttonEmployees.setEnabled(false);
        buttonResults.setEnabled(false);
        deleteButton.setEnabled(false);
        catsButton.setEnabled(true);
    }

    private void showStableDialog() {

        konushnyaName = JOptionPane.showInputDialog(panel, "Введите название конюшни:");
        konushnyaAddress = JOptionPane.showInputDialog(panel, "Введите адрес конюшни:");
        numOfHorses = Integer.parseInt(JOptionPane.showInputDialog(panel, "Введите количество лошадей:"));
        numOfStalls = 0;
        numOfWaterbowls = 0;
        heatingInStalls = false;
    }

    private void showStallDialog() {
        numOfStalls = Integer.parseInt(JOptionPane.showInputDialog(panel, "Введите количество стойл:"));
        while (numOfStalls > numOfHorses) {
            JOptionPane.showMessageDialog(panel, "Количество стойл не может быть больше количества лошадей!");
            numOfStalls = Integer.parseInt(JOptionPane.showInputDialog(panel, "Введите количество стойл:"));
        }
        numOfWaterbowls = Integer.parseInt(JOptionPane.showInputDialog(panel, "Введите количество водопоев:"));
        heatingInStalls = JOptionPane.showConfirmDialog(panel, "Есть ли отопление в стойлах?", "Отопление", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    private void showHorsesDialog() {
        horses = new ArrayList<>();
        for (int i = 0; i < numOfHorses; i++) {
            String id = JOptionPane.showInputDialog(panel, "Введите ID лошади:");
            String name = JOptionPane.showInputDialog(panel, "Введите имя лошади:");
            String gender = JOptionPane.showInputDialog(panel, "Введите пол лошади:");
            String age = JOptionPane.showInputDialog(panel, "Введите возраст лошади:");
            horses.add(new MainFrame.Horse(id, name, gender, age));
        }
    }

    private void showEmployeesDialog() {
        int numEmployees = numOfHorses / 3;
        employees = new ArrayList<>();

        for (int i = 0; i < numEmployees; i++) {
            String id = JOptionPane.showInputDialog(panel, "Введите ID сотрудника:");
            String name = JOptionPane.showInputDialog(panel, "Введите ФИО сотрудника:");
            String position = JOptionPane.showInputDialog(panel, "Введите должность сотрудника:");
            employees.add(new MainFrame.Employee(id, name, position));
        }
    }

    private void showResultsDialog() {

        StringBuilder result = new StringBuilder();
        result.append("Название конюшни: ").append(konushnyaName).append("\n");
        result.append("Адрес конюшни: ").append(konushnyaAddress).append("\n");
        result.append("Количество лошадей: ").append(numOfHorses).append("\n");
        result.append("Количество стойл: ").append(numOfStalls).append("\n");
        result.append("Количество водопоев: ").append(numOfWaterbowls).append("\n");
        result.append("Отопление в стойлах: ").append(heatingInStalls ? "Да" : "Нет").append("\n");

        result.append("Информация о лошадях:\n");
        for (MainFrame.Horse horse : horses) {
            result.append("ID: ").append(horse.getId()).append(", Имя: ").append(horse.getName())
                    .append(", Пол: ").append(horse.getGender()).append(", Возраст: ").append(horse.getAge()).append("\n");
        }

        result.append("Информация о сотрудниках:\n");
        for (MainFrame.Employee employee : employees) {
            result.append("ID: ").append(employee.getId()).append(", ФИО: ").append(employee.getName())
                    .append(", Должность: ").append(employee.getPosition()).append("\n");
        }

        JFrame resultsFrame = new JFrame("Результаты");
        resultsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JOptionPane.showMessageDialog(resultsFrame, result.toString(), "Результаты", JOptionPane.INFORMATION_MESSAGE);
    }

    private static class Horse {
        private String id;
        private String name;
        private String gender;
        private String age;

        public Horse(String id, String name, String gender, String age) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public String getAge() {
            return age;
        }
    }

    private static class Employee {
        private String id;
        private String name;
        private String position;

        public Employee(String id, String name, String position) {
            this.id = id;
            this.name = name;
            this.position = position;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }
    }
}



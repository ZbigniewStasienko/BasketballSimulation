import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Class implementing two windows that reads user preferences before starting simulation
public class WelcomeGUI {

    public static void main(String[] args) {
        numberOfGames();
    }
    public static void numberOfGames() {
        JFrame frame = new JFrame("Number of games selection");
        JPanel panel = new JPanel();

        JLabel label = new JLabel("    Choose the number of matches to play:");
        panel.add(label);

        String[] options = {"1", "2", "3", "4", "5"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        panel.add(comboBox);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(cancelButton);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gamesToPlay = Integer.parseInt((String) comboBox.getSelectedItem());
                showSecondWindow();
                frame.dispose();
            }
        });
        panel.add(okButton);

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 150);
        frame.setVisible(true);
    }

    private static void showSecondWindow() {
        JFrame secondFrame = new JFrame("Players generator");
        JPanel secondPanel = new JPanel();

        JButton button1 = new JButton("Generate players randomly");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.generatingPlayersOption = 1;
                secondFrame.dispose();
                startSimulation();
            }
        });

        JButton button2 = new JButton("Read players from file");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.generatingPlayersOption = 2;
                secondFrame.dispose();
                startSimulation();
            }
        });

        secondPanel.add(button1);
        secondPanel.add(button2);

        secondFrame.add(secondPanel);

        secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondFrame.setSize(300, 100);
        secondFrame.setVisible(true);
    }

    private static void startSimulation() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Main.runSimulation();
                return null;
            }
        };
        worker.execute();
    }
}

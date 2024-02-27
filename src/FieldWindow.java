import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

// Class for creating a window with a slider and a text pane
public class FieldWindow {
    private JFrame frame;
    private JTextPane textPane;
    private int sliderValue;

    public FieldWindow() {
        frame = new JFrame("Field");
        frame.setLayout(new BorderLayout());

        JLabel sliderLabel = new JLabel("Speed of simulation", SwingConstants.CENTER);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 600, 999, 980);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(null);
        slider.addChangeListener(new SliderChangeListener());

        JPanel sliderPanel = new JPanel(new BorderLayout());
        sliderPanel.add(slider, BorderLayout.CENTER);
        sliderPanel.add(sliderLabel, BorderLayout.NORTH);
        frame.add(sliderPanel, BorderLayout.NORTH);

        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setContentType("text/html");
        textPane.setBackground(Color.BLACK);
        frame.add(textPane, BorderLayout.CENTER);

        frame.setSize(340, 360);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Method to update the text displayed in the text pane
    public void update(String text) {
        String formattedText = "<html>" + text + "</html>";
        textPane.setText(formattedText);
    }

    // Listener class for slider changes
    private class SliderChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            if (!source.getValueIsAdjusting()) {
                sliderValue = source.getValue();
                Field.delay = sliderValue;
            }
        }
    }
}

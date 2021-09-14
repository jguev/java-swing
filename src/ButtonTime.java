// Author: Johanna Guevara
// Project Description:
// Write an application that displays four buttons labelled ‘1’, ‘2’, ‘3’ and ‘4’ and
// a label. Arrange the components as shown in Figure 3.7. The label initially
// displays the text ‘No button pushed’. When one of the four buttons is pushed
// the text in the label changes to ‘Last button pushed was no. X’, where X is the
// number of the button
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonTime {
    private JLabel label;
    private JButton lastButton = null;
    private JPanel buttonPanel = new JPanel(new BorderLayout());

    // constructor
    public ButtonTime() {
        int r = 2; // populate grid with 4 buttons
        JPanel buttonGridPanel = new JPanel(new GridLayout(r, r));
        ActionListener listener = e -> {
            lastButton = (JButton) e.getSource(); // source -> content
            label.setText("Last Button Pushed Was: " + e.getActionCommand());
        };
        for (int i = 0; i < r * r; i++) {
            String text = "" + (i + 1); // i know
            JButton button = new JButton(text);
            button.addActionListener(listener);
            buttonGridPanel.add(button);
        }

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(Box.createHorizontalStrut(20));
        label = new JLabel("No buttons pushed.");
        bottomPanel.add(label);
        buttonPanel.add(buttonGridPanel, BorderLayout.PAGE_START);
        buttonPanel.add(bottomPanel);
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Assignment 1");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ButtonTime().getButtonPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}
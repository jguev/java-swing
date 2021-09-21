
// Author: Johanna Guevara
// Project Description:
// This is an exercise that demonstrates how to create a simple GUI that uses a non-default layout manager,
// and how to use a simple state machine to keep track of buttons pushed
// GUI will use a 5-by-4 GridLayout with 5-pixel gaps between cells.

// 1 2 3 +
// 4 5 6 -
// 7 8 9 *
// ` 0 ` /

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CalculatorGUI implements ActionListener {

    JFrame guiFrame;
    JPanel buttonPanel;
    JTextField userInput;
    int operation = 0;
    int calculation;

    public CalculatorGUI() {
        guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        guiFrame.setTitle("Swing Calculator");
        guiFrame.setSize(270, 350);
        guiFrame.setLocationRelativeTo(null);

        // Calculator Display
        userInput = new JTextField();
        userInput.setHorizontalAlignment(JTextField.RIGHT);
        userInput.setEditable(false);
        guiFrame.add(userInput, BorderLayout.NORTH);
        userInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));

        buttonPanel = new JPanel();
        Color bkg = new Color(214, 243, 243, 255);
        buttonPanel.setBackground(bkg);

        buttonPanel.setLayout(new GridLayout(5, 4));
        guiFrame.add(buttonPanel, BorderLayout.CENTER);

        // Will add a for loop later, manually did it temporarily
        // 1 2 3 +
        addButton(buttonPanel, "1");
        addButton(buttonPanel, "2");
        addButton(buttonPanel, "3");

        // Addition
        JButton addButton = new JButton("+");
        addButton.setActionCommand("+");
        OperatorAction addAction = new OperatorAction(1);
        addButton.addActionListener(addAction);
        buttonPanel.add(addButton);

        // 4 5 6 -
        addButton(buttonPanel, "4");
        addButton(buttonPanel, "5");
        addButton(buttonPanel, "6");

        // Subtraction
        JButton subButton = new JButton("-");
        subButton.setActionCommand("-");
        OperatorAction subAction = new OperatorAction(2);
        subButton.addActionListener(subAction);
        buttonPanel.add(subButton);

        // 7 8 9 *
        addButton(buttonPanel, "7");
        addButton(buttonPanel, "8");
        addButton(buttonPanel, "9");

        // Multiplication
        JButton multButton = new JButton("*");
        multButton.setActionCommand("*");
        OperatorAction multAction = new OperatorAction(3);
        multButton.addActionListener(multAction);
        buttonPanel.add(multButton);

        // ` 0 ` /
        addButton(buttonPanel, " ");

        addButton(buttonPanel, "0");
        addButton(buttonPanel, " ");

        // Division
        JButton divButton = new JButton("/");
        divButton.setActionCommand("/");
        OperatorAction divAction = new OperatorAction(4);
        divButton.addActionListener(divAction);
        buttonPanel.add(divButton);

        // this equal button shouldn't visually exist on the GUI, only here for testing purposes

        JButton equalsButton = new JButton("=");
        equalsButton.setActionCommand("=");
        equalsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (!userInput.getText().isEmpty()) {
                    int number = Integer.parseInt(userInput.getText());
                    if (operation == 1) {
                        int calculate = calculation + number;
                        userInput.setText(Integer.toString(calculate));
                    } else if (operation == 2) {
                        int calculate = calculation - number;
                        userInput.setText(Integer.toString(calculate));
                    }
                    else if (operation == 3) {
                        int calculate = calculation * number;
                        userInput.setText(Integer.toString(calculate));
                    }
                    else if (operation == 4){
                        int calculate = calculation / number;
                        userInput.setText(Integer.toString(calculate));
                    }
                }
            }
        });

        buttonPanel.add(equalsButton);
        guiFrame.setVisible(true);
    }

    private void addButton(Container parent, String name) {
        JButton b = new JButton(name);
        b.setActionCommand(name);
        b.addActionListener(this);
        parent.add(b);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        userInput.setText(action);
    }

    private class OperatorAction implements ActionListener {
        private int operator;

        public OperatorAction(int operation) {
            operator = operation;
        }
        public void actionPerformed(ActionEvent event) {
            calculation = Integer.parseInt(userInput.getText());
            operation = operator;
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorGUI();
            }
        });
    }
}

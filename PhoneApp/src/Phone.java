
// Author: Johanna Guevara
// Project Description:
// In Class Assignment, This program will simulate a phone call interaction.
// It will have the ability to input a phone number, make a call and end a call
// ultimately wiping the text field clean from input.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Phone extends JFrame {

    String input;

    private final JPanel userInput = new JPanel();
    private final JPanel numPanel = new JPanel();
    private final JLabel displayLabel = new JLabel ("");
    private final JTextField displayTextField = new JTextField(15);

    // Introduce buttons
   JButton b1 = new JButton("1");
   JButton b2 = new JButton("2");
   JButton b3 = new JButton("3");
   JButton b4 = new JButton("4");
   JButton b5 = new JButton("5");
   JButton b6 = new JButton("6");
   JButton b7 = new JButton("7");
   JButton b8 = new JButton("8");
   JButton b9 = new JButton("9");
   JButton b0 = new JButton("0");
   JButton clearButton = new JButton("Clear");
   JButton callButton = new JButton("Call");

    public static void main(String[] args) {
        new Phone();
    }

    public Phone()
    {
        setTitle("Phone App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userInput.setLayout(new BorderLayout());
        userInput.add(displayLabel,BorderLayout.NORTH);
        userInput.add(displayTextField,BorderLayout.CENTER);

        // Add buttons to the panel and add an action listener to 0-9
        numPanel.setLayout(new GridLayout(4,3));
        lengthCount listener= new lengthCount();
        numPanel.add(b1); b1.addActionListener(listener);
        numPanel.add(b2); b2.addActionListener(listener);
        numPanel.add(b3); b3.addActionListener(listener);
        numPanel.add(b4); b4.addActionListener(listener);
        numPanel.add(b5); b5.addActionListener(listener);
        numPanel.add(b6); b6.addActionListener(listener);
        numPanel.add(b7); b7.addActionListener(listener);
        numPanel.add(b8); b8.addActionListener(listener);
        numPanel.add(b9); b9.addActionListener(listener);
        numPanel.add(clearButton);
        numPanel.add(b0); b0.addActionListener(listener);
        numPanel.add(callButton);

        // Clear and Call require logic with the action listener
        clearButton.addActionListener(new ClearingListener());
        callButton.addActionListener(new CallingListener());

        // Set the color palette
        Color bkg = new Color(181,201,165,255);
        numPanel.setBackground(bkg);
        setLayout(new BorderLayout());
        add(userInput,BorderLayout.NORTH); // User Input at the top
        add(numPanel,BorderLayout.SOUTH);  // Buttons placed below
        setVisible(true);
    }

    private class CallingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            call(displayTextField.getText());

        }
    }

    private class ClearingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            hangup();
        }
    }

    public void hangup() {
        displayTextField.setText(" ");
    }

    public void call(String phoneNumber) {
        displayTextField.setText(phoneNumber);
        if("Call".equalsIgnoreCase(callButton.getText())){
            callButton.setText("End");
        }
        else if("End".equalsIgnoreCase(callButton.getText())){
            callButton.setText("Call");
            displayTextField.setText("");
        }

    }

    // This method allows us to keep track of the length of the user input
    private class lengthCount implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== b1) {
                displayTextField.setText(displayTextField.getText()+"1");
            }
            else if (e.getSource()== b2) {
                displayTextField.setText(displayTextField.getText()+"2");
            }
            else if (e.getSource()== b3) {
                displayTextField.setText(displayTextField.getText()+"3");
            }
            else if (e.getSource()== b4) {
                displayTextField.setText(displayTextField.getText()+"4");
            }
            else if (e.getSource()== b5) {
                displayTextField.setText(displayTextField.getText()+"5");
            }
            else if (e.getSource()== b6) {
                displayTextField.setText(displayTextField.getText()+"6");
            }
            else if (e.getSource()== b7) {
                displayTextField.setText(displayTextField.getText()+"7");
            }
            else if (e.getSource()== b8) {
                displayTextField.setText(displayTextField.getText()+"8");
            }
            else if (e.getSource()== b9) {
                displayTextField.setText(displayTextField.getText()+"9");
            }
            else if (e.getSource()==b0) {
                displayTextField.setText(displayTextField.getText()+"0");
            }


        }
    }
}
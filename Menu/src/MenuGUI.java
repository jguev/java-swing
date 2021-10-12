
// Author: Johanna Guevara
// Project Description:
// This program explores JMenuBar and builds a simple drop down menu with 3
// options: "New", "Open", "Save". Every option has a corresponding dialog box
// confirming the selection.

import javax.swing.*;
import java.awt.event.*;
class MenuGUI extends JFrame implements ActionListener {
    public MenuGUI(String title) {
        super(title);
        setBounds(40,40,400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Exit");
        quit.addActionListener(this);

        // Menu Option: New
        menuBar.add(file);
        JMenuItem o_new = new JMenuItem("New");
        o_new.addActionListener(this);
        file.add(o_new);

        // Menu Option: Open
        menuBar.add(file);
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);
        file.add(open);

        // Menu Option: Save
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(this);
        file.add(save);

        file.add(quit);
    }
    public static void main(String[] args) {
        MenuGUI gui = new MenuGUI("Menu");
        gui.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        // A safe way to exit the current program run
        if (choice.equals("Exit")) {
            System.exit(0);
        }
        // When these options are selected display the following text
        else if (choice.equals("New")) {
            JOptionPane.showMessageDialog(this,"New file.");
        }
        else if (choice.equals("Open")){
            JOptionPane.showMessageDialog(this, "Opened.");
        }
        else if (choice.equals("Save")){
            JOptionPane.showMessageDialog(this, "File saved.");
        }
    }
}
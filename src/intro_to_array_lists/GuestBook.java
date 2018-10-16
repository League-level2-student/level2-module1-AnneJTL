package intro_to_array_lists;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class GuestBook implements ActionListener {
    private JFrame window;
    private JPanel panel;
    private JButton addButton, viewButton;
    private List<String> allNames;

	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names".
    private void GUI(){
        window = new JFrame("ArrayList");
        window.setSize(new Dimension(400,300));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();

        Dimension buttonSize = new Dimension(150,100);
        addButton = new JButton("Add Name");
        addButton.addActionListener(this);
        addButton.setPreferredSize(buttonSize);
        viewButton = new JButton("View Names");
        viewButton.addActionListener(this);
        viewButton.setPreferredSize(buttonSize);


        panel.add(addButton);
        panel.add(viewButton);

        window.add(panel);
        window.setVisible(true);

    }

    public GuestBook(){

        allNames = new ArrayList<>();
        GUI();
    }
    public static void main(String[] args) {
        new GuestBook();



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // When the add name button is clicked, display an input dialog that asks the user to enter a name.
            // Add that name to an ArrayList.
            String newName = JOptionPane.showInputDialog("Which name do you want to add ?");
            allNames.add(newName);

        } else if ((JButton) e.getSource() == viewButton) {
            // When the "View Names" button is clicked, display a message dialog that displays
            // all the names added to the list. Format the list as follows:
            // Guest #1: Bob Banders
            // Guest #2: Sandy Summers
            // Guest #3: Greg Ganders
            // Guest #4: Donny Doners
            StringBuilder displayAllNames = new StringBuilder();
            for (int i = 1; i <= allNames.size(); i++){
                displayAllNames.append("Guest #" + i + ": " + allNames.get(i-1) + '\n');
            }
            JOptionPane.showMessageDialog(null, displayAllNames);

        } else {
            JOptionPane.showOptionDialog(null, "There is something wired", "Error",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,null,null,null);
        }

    }
}

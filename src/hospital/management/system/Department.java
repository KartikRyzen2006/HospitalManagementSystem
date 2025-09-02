package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department() {
        // Main Frame Settings
        setTitle("Department Information"); // Set the title of the frame
        setSize(700, 500); // Set the size of the frame
        setLocation(350, 250); // Set the location of the frame on the screen
        setUndecorated(true); // Remove the default window decorations
        getContentPane().setBackground(new Color(18, 18, 18)); // Set a dark background color for a futuristic look
        setLayout(null); // Set the layout to null for absolute positioning

        // Main Panel
        JPanel panel = new JPanel(); // Create a main panel
        panel.setBounds(5, 5, 690, 490); // Set the position and size of the panel
        panel.setBackground(new Color(25, 25, 25)); // Set a slightly lighter dark background color
        panel.setLayout(null); // Set the layout of the panel to null for absolute positioning
        add(panel); // Add the panel to the frame

        // Table
        JTable table = new JTable(); // Create a table to display department information
        table.setBounds(0, 40, 700, 350); // Set the position and size of the table
        table.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        table.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        table.setFont(new Font("Inter", Font.PLAIN, 14)); // Set the font of the table
        table.setGridColor(new Color(0, 255, 209)); // Set the grid color to neon cyan
        table.setSelectionBackground(new Color(0, 255, 209)); // Set the selection background color to neon cyan
        table.setSelectionForeground(new Color(18, 18, 18)); // Set the selection text color to dark
        panel.add(table); // Add the table to the panel

        // Load department data from the database
        try {
            conn c = new conn(); // Create a database connection
            String q = "select * from department"; // SQL query to fetch all department data
            ResultSet resultSet = c.statement.executeQuery(q); // Execute the query
            table.setModel(DbUtils.resultSetToTableModel(resultSet)); // Populate the table with the result set means making data visible and usable
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }

        // Column Headers
        JLabel label1 = new JLabel("Department"); // Create a label for the department column
        label1.setBounds(145, 11, 105, 20); // Set the position and size of the label
        label1.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label1.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label1); // Add the label to the panel

        JLabel label2 = new JLabel("Phone Number"); // Create a label for the phone number column
        label2.setBounds(431, 11, 150, 20); // Set the position and size of the label
        label2.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label2.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label2); // Add the label to the panel

        // Back Button
        JButton b1 = new JButton("Back"); // Create a back button
        b1.setBounds(400, 410, 130, 30); // Set the position and size of the button
        b1.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the button
        b1.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        b1.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        b1.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the current frame when the back button is clicked
            }
        });
        panel.add(b1); // Add the back button to the panel

        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        new Department(); // Create a new instance of the Department class to display the frame
    }
}
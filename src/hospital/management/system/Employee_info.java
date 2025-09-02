package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {

    Employee_info() {
        // Main Frame Settings
        setTitle("Employee Information"); // Set the title of the frame
        setSize(1000, 600); // Set the size of the frame
        setLocation(350, 230); // Set the location of the frame on the screen
        setUndecorated(true); // Remove the default window decorations
        getContentPane().setBackground(new Color(18, 18, 18)); // Set a dark background color for a futuristic look
        setLayout(null); // Set the layout to null for absolute positioning

        // Main Panel
        JPanel panel = new JPanel(); // Create a main panel
        panel.setBounds(5, 5, 990, 590); // Set the position and size of the panel
        panel.setBackground(new Color(25, 25, 25)); // Set a slightly lighter dark background color
        panel.setLayout(null); // Set the layout of the panel to null for absolute positioning
        add(panel); // Add the panel to the frame

        // Table
        JTable table = new JTable(); // Create a table to display employee information
        table.setBounds(10, 34, 980, 450); // Set the position and size of the table
        table.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        table.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        table.setFont(new Font("Inter", Font.PLAIN, 14)); // Set the font of the table
        table.setGridColor(new Color(0, 255, 209)); // Set the grid color to neon cyan
        table.setSelectionBackground(new Color(0, 255, 209)); // Set the selection background color to neon cyan
        table.setSelectionForeground(new Color(18, 18, 18)); // Set the selection text color to dark
        panel.add(table); // Add the table to the panel

        // Load employee data from the database
        try {
            conn c = new conn(); // Create a database connection
            String q = "select * from EMP_INFO"; // SQL query to fetch all employee data
            ResultSet resultSet = c.statement.executeQuery(q); // Execute the query
            table.setModel(DbUtils.resultSetToTableModel(resultSet)); // Populate the table with the result set
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }

        // Column Headers
        JLabel label1 = new JLabel("Name"); // Create a label for the name column
        label1.setBounds(41, 9, 70, 20); // Set the position and size of the label
        label1.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label1.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label1); // Add the label to the panel

        JLabel label2 = new JLabel("Age"); // Create a label for the age column
        label2.setBounds(180, 9, 70, 20); // Set the position and size of the label
        label2.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label2.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label2); // Add the label to the panel

        JLabel label3 = new JLabel("Phone Number"); // Create a label for the phone number column
        label3.setBounds(340, 9, 150, 20); // Set the position and size of the label
        label3.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label3.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label3); // Add the label to the panel

        JLabel label4 = new JLabel("Salary"); // Create a label for the salary column
        label4.setBounds(510, 9, 70, 20); // Set the position and size of the label
        label4.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label4.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label4); // Add the label to the panel

        JLabel label5 = new JLabel("E-mail"); // Create a label for the email column
        label5.setBounds(670, 9, 70, 20); // Set the position and size of the label
        label5.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label5.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label5); // Add the label to the panel

        JLabel label6 = new JLabel("Aadhar Number"); // Create a label for the Aadhar number column
        label6.setBounds(830, 9, 150, 20); // Set the position and size of the label
        label6.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label6.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label6); // Add the label to the panel

        // Back Button
        JButton button = new JButton("Back"); // Create a back button
        button.setBounds(350, 500, 120, 30); // Set the position and size of the button
        button.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the button
        button.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        button.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the current frame when the back button is clicked
            }
        });
        panel.add(button); // Add the back button to the panel

        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        new Employee_info(); // Create a new instance of the Employee_info class to display the frame
    }
}
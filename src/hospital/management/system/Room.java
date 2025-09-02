package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table; // Table to display room information

    Room() {
        // Main Frame Settings
        setTitle("Room Information"); // Set the title of the frame
        setSize(900, 600); // Set the size of the frame
        setLocation(300, 230); // Set the location of the frame on the screen
        setUndecorated(true); // Remove the default window decorations
        getContentPane().setBackground(new Color(18, 18, 18)); // Set a dark background color for a futuristic look
        setLayout(null); // Set the layout to null for absolute positioning

        // Main Panel
        JPanel panel = new JPanel(); // Create a main panel
        panel.setBounds(5, 5, 890, 590); // Set the position and size of the panel
        panel.setBackground(new Color(25, 25, 25)); // Set a slightly lighter dark background color
        panel.setLayout(null); // Set the layout of the panel to null for absolute positioning
        add(panel); // Add the panel to the frame

        // Logo
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/roomm.png")); // Load the logo image
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Resize the image
        ImageIcon imageIcon1 = new ImageIcon(image); // Create a new image icon with the resized image
        JLabel label = new JLabel(imageIcon1); // Create a label to display the image
        label.setBounds(600, 200, 200, 200); // Set the position and size of the label
        panel.add(label); // Add the label to the panel

        // Table
        table = new JTable(); // Create a table to display room information
        table.setBounds(10, 40, 500, 400); // Set the position and size of the table
        table.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        table.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        table.setFont(new Font("Inter", Font.PLAIN, 14)); // Set the font of the table
        table.setGridColor(new Color(0, 255, 209)); // Set the grid color to neon cyan
        table.setSelectionBackground(new Color(0, 255, 209)); // Set the selection background color to neon cyan
        table.setSelectionForeground(new Color(18, 18, 18)); // Set the selection text color to dark
        panel.add(table); // Add the table to the panel

        // Load room data from the database
        try {
            conn c = new conn(); // Create a database connection
            String q = "select * from room"; // SQL query to fetch all room data
            ResultSet resultSet = c.statement.executeQuery(q); // Execute the query
            table.setModel(DbUtils.resultSetToTableModel(resultSet)); // Populate the table with the result set
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }

        // Column Headers
        JLabel label1 = new JLabel("Room No"); // Create a label for the Room No column
        label1.setBounds(12, 15, 80, 15); // Set the position and size of the label
        label1.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label1.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label1); // Add the label to the panel

        JLabel label2 = new JLabel("Availability"); // Create a label for the Availability column
        label2.setBounds(140, 15, 90, 15); // Set the position and size of the label
        label2.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label2.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label2); // Add the label to the panel

        JLabel label3 = new JLabel("Price"); // Create a label for the Price column
        label3.setBounds(290, 15, 80, 15); // Set the position and size of the label
        label3.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label3.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label3); // Add the label to the panel

        JLabel label4 = new JLabel("Bed Type"); // Create a label for the Bed Type column
        label4.setBounds(400, 15, 80, 15); // Set the position and size of the label
        label4.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label4.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label4); // Add the label to the panel

        // Back Button
        JButton back = new JButton("Back"); // Create a back button
        back.setBounds(200, 500, 120, 30); // Set the position and size of the button
        back.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the button
        back.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        back.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        back.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the current frame when the back button is clicked
            }
        });
        panel.add(back); // Add the back button to the panel

        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        new Room(); // Create a new instance of the Room class to display the frame
    }
}
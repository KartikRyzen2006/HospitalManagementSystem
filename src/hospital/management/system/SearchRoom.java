package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice; // Dropdown for selecting room status
    JTable table; // Table to display room information

    // Constructor to initialize the SearchRoom frame
    SearchRoom() {
        // Main Frame Settings
        setTitle("Search Room"); // Set the title of the frame
        setSize(700, 500); // Set the size of the frame
        setLocation(450, 250); // Set the location of the frame on the screen
        setUndecorated(true); // Remove the default window decorations
        getContentPane().setBackground(new Color(18, 18, 18)); // Set a dark background color for a futuristic look
        setLayout(null); // Set the layout to null for absolute positioning

        // Main Panel
        JPanel panel = new JPanel(); // Create a main panel
        panel.setBounds(5, 5, 690, 490); // Set the position and size of the panel
        panel.setBackground(new Color(25, 25, 25)); // Set a slightly lighter dark background color
        panel.setLayout(null); // Set the layout of the panel to null for absolute positioning
        add(panel); // Add the panel to the frame

        // Title Label
        JLabel For = new JLabel("Search For Room"); // Create a label for the title
        For.setBounds(250, 11, 186, 31); // Set the position and size of the label
        For.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        For.setFont(new Font("Inter", Font.BOLD, 20)); // Set the font of the label
        panel.add(For); // Add the label to the panel

        // Status Label and Choice
        JLabel status = new JLabel("Status :"); // Create a label for the status
        status.setBounds(70, 70, 80, 20); // Set the position and size of the label
        status.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        status.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        panel.add(status); // Add the label to the panel

        choice = new Choice(); // Create a dropdown for selecting room status
        choice.setBounds(170, 70, 120, 20); // Set the position and size of the dropdown
        choice.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        choice.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        choice.add("Available"); // Add "Available" option to the dropdown
        choice.add("Occupied"); // Add "Occupied" option to the dropdown
        panel.add(choice); // Add the dropdown to the panel

        // Table
        table = new JTable(); // Create a table to display room information
        table.setBounds(0, 187, 700, 210); // Set the position and size of the table
        table.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        table.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        table.setFont(new Font("Inter", Font.PLAIN, 14)); // Set the font of the table
        table.setGridColor(new Color(0, 255, 209)); // Set the grid color to neon cyan
        table.setSelectionBackground(new Color(0, 255, 209)); // Set the selection background color to neon cyan
        table.setSelectionForeground(new Color(18, 18, 18)); // Set the selection text color to dark
        panel.add(table); // Add the table to the panel

        // Load initial room data
        try {
            conn c = new conn(); // Create a database connection
            String q = "select * from room"; // SQL query to fetch all room data
            ResultSet resultSet = c.statement.executeQuery(q); // Execute the query
            table.setModel(DbUtils.resultSetToTableModel(resultSet)); // Populate the table with the result set
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }

        // Column Headers
        JLabel Roomno = new JLabel("Room Number"); // Create a label for the room number column
        Roomno.setBounds(23, 162, 150, 20); // Set the position and size of the label
        Roomno.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        Roomno.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        panel.add(Roomno); // Add the label to the panel

        JLabel available = new JLabel("Availability"); // Create a label for the availability column
        available.setBounds(175, 162, 150, 20); // Set the position and size of the label
        available.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        available.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        panel.add(available); // Add the label to the panel

        JLabel price = new JLabel("Price"); // Create a label for the price column
        price.setBounds(458, 162, 150, 20); // Set the position and size of the label
        price.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        price.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        panel.add(price); // Add the label to the panel

        JLabel Bed = new JLabel("Bed Type"); // Create a label for the bed type column
        Bed.setBounds(580, 162, 150, 20); // Set the position and size of the label
        Bed.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        Bed.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        panel.add(Bed); // Add the label to the panel

        // Search Button
        JButton Search = new JButton("Search"); // Create a search button
        Search.setBounds(200, 420, 120, 25); // Set the position and size of the button
        Search.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the button
        Search.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        Search.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        Search.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '" + choice.getSelectedItem() + "'"; // SQL query to filter by selected status
                try {
                    conn c = new conn(); // Create a database connection
                    ResultSet resultSet = c.statement.executeQuery(q); // Execute the query
                    table.setModel(DbUtils.resultSetToTableModel(resultSet)); // Populate the table with the result set
                } catch (Exception E) {
                    E.printStackTrace(); // Print any exceptions that occur
                }
            }
        });
        panel.add(Search); // Add the search button to the panel

        // Back Button
        JButton Back = new JButton("Back"); // Create a back button
        Back.setBounds(380, 420, 120, 25); // Set the position and size of the button
        Back.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the button
        Back.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        Back.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        Back.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the current frame
            }
        });
        panel.add(Back); // Add the back button to the panel

        setVisible(true); // Make the frame visible
    }

    // Main method to run the application
    public static void main(String[] args) {
        new SearchRoom(); // Create a new instance of the SearchRoom class
    }
}
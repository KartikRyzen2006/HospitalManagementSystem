package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {
    patient_discharge() {
        // Main Frame Settings
        setTitle("Patient Discharge"); // Set the title of the frame
        setSize(800, 400); // Set the size of the frame
        setLocation(400, 250); // Set the location of the frame on the screen
        setUndecorated(true); // Remove the default window decorations
        getContentPane().setBackground(new Color(18, 18, 18)); // Set a dark background color for a futuristic look
        setLayout(null); // Set the layout to null for absolute positioning

        // Main Panel
        JPanel panel = new JPanel(); // Create a main panel
        panel.setBounds(5, 5, 790, 390); // Set the position and size of the panel
        panel.setBackground(new Color(25, 25, 25)); // Set a slightly lighter dark background color
        panel.setLayout(null); // Set the layout of the panel to null for absolute positioning
        add(panel); // Add the panel to the frame

        // Title Label
        JLabel label = new JLabel("CHECK-OUT"); // Create a label for the title
        label.setBounds(100, 20, 150, 20); // Set the position and size of the label
        label.setFont(new Font("Inter", Font.BOLD, 20)); // Set the font of the label
        label.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label); // Add the label to the panel

        // Customer ID Label and Choice
        JLabel label2 = new JLabel("Customer Id"); // Create a label for the customer ID
        label2.setBounds(30, 80, 150, 20); // Set the position and size of the label
        label2.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label2.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label2); // Add the label to the panel

        Choice choice = new Choice(); // Create a dropdown for selecting customer IDs
        choice.setBounds(200, 80, 150, 25); // Set the position and size of the dropdown
        choice.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        choice.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(choice); // Add the dropdown to the panel

        // Load customer IDs from the database
        try {
            conn c = new conn(); // Create a database connection
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info"); // Execute the query to fetch customer IDs
            while (resultSet.next()) {
                choice.add(resultSet.getString("number")); // Add each customer ID to the dropdown
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }

        // Room Number Label and Display
        JLabel label3 = new JLabel("Room Number"); // Create a label for the room number
        label3.setBounds(30, 130, 150, 20); // Set the position and size of the label
        label3.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label3.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label3); // Add the label to the panel

        JLabel RNo = new JLabel(); // Create a label to display the room number
        RNo.setBounds(200, 130, 150, 20); // Set the position and size of the label
        RNo.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        RNo.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(RNo); // Add the label to the panel

        // In Time Label and Display
        JLabel label4 = new JLabel("In Time"); // Create a label for the in-time
        label4.setBounds(30, 180, 150, 20); // Set the position and size of the label
        label4.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label4.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label4); // Add the label to the panel

        JLabel INTime = new JLabel(); // Create a label to display the in-time
        INTime.setBounds(200, 180, 250, 20); // Set the position and size of the label
        INTime.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        INTime.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(INTime); // Add the label to the panel

        // Out Time Label and Display
        JLabel label5 = new JLabel("Out Time"); // Create a label for the out-time
        label5.setBounds(30, 230, 150, 20); // Set the position and size of the label
        label5.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        label5.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label5); // Add the label to the panel

        Date date = new Date(); // Get the current date and time
        JLabel OUTTime = new JLabel("" + date); // Create a label to display the out-time
        OUTTime.setBounds(200, 230, 250, 20); // Set the position and size of the label
        OUTTime.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        OUTTime.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(OUTTime); // Add the label to the panel

        // Discharge Button
        JButton discharge = new JButton("Discharge"); // Create a discharge button
        discharge.setBounds(30, 300, 120, 30); // Set the position and size of the button
        discharge.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the button
        discharge.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        discharge.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        discharge.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn(); // Create a database connection
                try {
                    // Debugging: Print the selected customer ID and room number
                    System.out.println("Selected Customer ID: " + choice.getSelectedItem());
                    System.out.println("Room Number: " + RNo.getText());

                    // Delete the patient from Patient_Info table
                    c.statement.executeUpdate("DELETE FROM Patient_Info WHERE number = '" + choice.getSelectedItem() + "'");

                    // Update the room availability in the room table
                    c.statement.executeUpdate("UPDATE room SET Availability = 'Available' WHERE room_no = '" + RNo.getText() + "'");

                    JOptionPane.showMessageDialog(null, "Patient Discharged Successfully"); // Show a success message
                    setVisible(false); // Hide the current frame
                } catch (Exception E) {
                    E.printStackTrace(); // Print any exceptions that occur
                    JOptionPane.showMessageDialog(null, "Error: " + E.getMessage()); // Show an error message
                }
            }
        });
        panel.add(discharge); // Add the discharge button to the panel

        // Check Button
        JButton Check = new JButton("Check"); // Create a check button
        Check.setBounds(170, 300, 120, 30); // Set the position and size of the button
        Check.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the button
        Check.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        Check.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        Check.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn(); // Create a database connection
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info where number = '" + choice.getSelectedItem() + "'"); // Execute the query to fetch patient details
                    while (resultSet.next()) {
                        RNo.setText(resultSet.getString("Room_Number")); // Set the room number label
                        INTime.setText(resultSet.getString("Time")); // Set the in-time label
                    }
                } catch (Exception E) {
                    E.printStackTrace(); // Print any exceptions that occur
                    JOptionPane.showMessageDialog(null, "Error: " + E.getMessage()); // Show an error message
                }
            }
        });
        panel.add(Check); // Add the check button to the panel

        // Back Button
        JButton Back = new JButton("Back"); // Create a back button
        Back.setBounds(300, 300, 120, 30); // Set the position and size of the button
        Back.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the button
        Back.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        Back.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        Back.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the current frame when the back button is clicked
            }
        });
        panel.add(Back); // Add the back button to the panel

        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        new patient_discharge(); // Create a new instance of the patient_discharge class to display the frame
    }
}
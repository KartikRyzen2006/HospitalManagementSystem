package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {

    update_patient_details() {
        // Main Frame Settings
        setTitle("Update Patient Details"); // Set the title of the frame
        setSize(950, 500); // Set the size of the frame
        setLocation(400, 250); // Set the location of the frame on the screen
        setUndecorated(true); // Remove the default window decorations
        getContentPane().setBackground(new Color(18, 18, 18)); // Set a dark background color for a futuristic look
        setLayout(null); // Set the layout to null for absolute positioning

        // Main Panel
        JPanel panel = new JPanel(); // Create a main panel
        panel.setBounds(5, 5, 940, 490); // Set the position and size of the panel
        panel.setBackground(new Color(25, 25, 25)); // Set a slightly lighter dark background color
        panel.setLayout(null); // Set the layout of the panel to null for absolute positioning
        add(panel); // Add the panel to the frame

        // Logo
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png")); // Load the logo image
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT); // Resize the image
        ImageIcon imageIcon1 = new ImageIcon(image); // Create a new image icon with the resized image
        JLabel label = new JLabel(imageIcon1); // Create a label to display the image
        label.setBounds(500, 60, 300, 300); // Set the position and size of the label
        panel.add(label); // Add the label to the panel

        // Title Label
        JLabel label1 = new JLabel("Update Patient Details"); // Create a label for the title
        label1.setBounds(124, 11, 260, 25); // Set the position and size of the label
        label1.setFont(new Font("Inter", Font.BOLD, 20)); // Set the font of the label
        label1.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label1); // Add the label to the panel

        // Name Label and Choice
        JLabel label2 = new JLabel("Name :"); // Create a label for the name
        label2.setBounds(25, 88, 100, 14); // Set the position and size of the label
        label2.setFont(new Font("Inter", Font.PLAIN, 14)); // Set the font of the label
        label2.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label2); // Add the label to the panel

        Choice choice = new Choice(); // Create a dropdown for selecting patient names
        choice.setBounds(248, 85, 140, 25); // Set the position and size of the dropdown
        choice.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        choice.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(choice); // Add the dropdown to the panel

        // Load patient names from the database
        try {
            conn c = new conn(); // Create a database connection
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info"); // Execute the query to fetch patient names
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name")); // Add each patient name to the dropdown
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }

        // Room Number Label and TextField
        JLabel label3 = new JLabel("Room Number :"); // Create a label for the room number
        label3.setBounds(25, 129, 120, 14); // Set the position and size of the label
        label3.setFont(new Font("Inter", Font.PLAIN, 14)); // Set the font of the label
        label3.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label3); // Add the label to the panel

        JTextField textFieldR = new JTextField(); // Create a text field for the room number
        textFieldR.setBounds(248, 129, 140, 20); // Set the position and size of the text field
        textFieldR.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        textFieldR.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        textFieldR.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        panel.add(textFieldR); // Add the text field to the panel

        // In-Time Label and TextField
        JLabel label4 = new JLabel("In-Time  :"); // Create a label for the in-time
        label4.setBounds(25, 174, 100, 14); // Set the position and size of the label
        label4.setFont(new Font("Inter", Font.PLAIN, 14)); // Set the font of the label
        label4.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label4); // Add the label to the panel

        JTextField textFieldINTIme = new JTextField(); // Create a text field for the in-time
        textFieldINTIme.setBounds(248, 174, 140, 20); // Set the position and size of the text field
        textFieldINTIme.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        textFieldINTIme.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        textFieldINTIme.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        panel.add(textFieldINTIme); // Add the text field to the panel

        // Amount Paid Label and TextField
        JLabel label5 = new JLabel("Amount Paid (Rs) :"); // Create a label for the amount paid
        label5.setBounds(25, 216, 150, 14); // Set the position and size of the label
        label5.setFont(new Font("Inter", Font.PLAIN, 14)); // Set the font of the label
        label5.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label5); // Add the label to the panel

        JTextField textFieldAmount = new JTextField(); // Create a text field for the amount paid
        textFieldAmount.setBounds(248, 216, 140, 20); // Set the position and size of the text field
        textFieldAmount.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        textFieldAmount.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        textFieldAmount.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        panel.add(textFieldAmount); // Add the text field to the panel

        // Pending Amount Label and TextField
        JLabel label6 = new JLabel("Pending Amount (Rs) :"); // Create a label for the pending amount
        label6.setBounds(25, 261, 160, 16); // Set the position and size of the label
        label6.setFont(new Font("Inter", Font.PLAIN, 14)); // Set the font of the label
        label6.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(label6); // Add the label to the panel

        JTextField textFieldPending = new JTextField(); // Create a text field for the pending amount
        textFieldPending.setBounds(248, 261, 140, 20); // Set the position and size of the text field
        textFieldPending.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        textFieldPending.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        textFieldPending.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        panel.add(textFieldPending); // Add the text field to the panel

        // Check Button
        JButton check = new JButton("CHECK"); // Create a check button
        check.setBounds(281, 378, 89, 23); // Set the position and size of the button
        check.setFont(new Font("Inter", Font.BOLD, 12)); // Set the font of the button
        check.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        check.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        check.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem(); // Get the selected patient name
                String q = "select * from Patient_Info where Name = '" + id + "'"; // SQL query to fetch patient details
                try {
                    conn c = new conn(); // Create a database connection
                    ResultSet resultSet = c.statement.executeQuery(q); // Execute the query
                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_Number")); // Set the room number text field
                        textFieldINTIme.setText(resultSet.getString("Time")); // Set the in-time text field
                        textFieldAmount.setText(resultSet.getString("Deposit")); // Set the amount paid text field
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no = '" + textFieldR.getText() + "'"); // Fetch room details
                    while (resultSet1.next()) {
                        String price = resultSet1.getString("Price"); // Get the room price
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText()); // Calculate pending amount
                        textFieldPending.setText("" + amountPaid); // Set the pending amount text field
                    }
                } catch (Exception E) {
                    E.printStackTrace(); // Print any exceptions that occur
                }
            }
        });
        panel.add(check); // Add the check button to the panel

        // Update Button
        JButton update = new JButton("UPDATE"); // Create an update button
        update.setBounds(56, 378, 89, 23); // Set the position and size of the button
        update.setFont(new Font("Inter", Font.BOLD, 12)); // Set the font of the button
        update.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        update.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        update.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn(); // Create a database connection
                    String q = choice.getSelectedItem(); // Get the selected patient name
                    String room = textFieldR.getText(); // Get the room number from the text field
                    String time = textFieldINTIme.getText(); // Get the in-time from the text field
                    String amount = textFieldAmount.getText(); // Get the amount paid from the text field
                    c.statement.executeUpdate("update Patient_Info set Room_Number = '" + room + "', Time = '" + time + "', Deposit = '" + amount + "' where name = '" + q + "'"); // Update the patient details in the database
                    JOptionPane.showMessageDialog(null, "Updated Successfully"); // Show a success message
                    setVisible(false); // Hide the current frame
                } catch (Exception E) {
                    E.printStackTrace(); // Print any exceptions that occur
                }
            }
        });
        panel.add(update); // Add the update button to the panel

        // Back Button
        JButton back = new JButton("BACK"); // Create a back button
        back.setBounds(168, 378, 89, 23); // Set the position and size of the button
        back.setFont(new Font("Inter", Font.BOLD, 12)); // Set the font of the button
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
        new update_patient_details(); // Create a new instance of the update_patient_details class to display the frame
    }
}
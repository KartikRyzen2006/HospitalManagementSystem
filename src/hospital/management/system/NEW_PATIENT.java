package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {
    JComboBox<String> comboBox; // Dropdown for selecting ID type
    JTextField textFieldNumber, textName, textDisease, textFieldDeposit; // Text fields for various patient details
    JRadioButton r1, r2; // Radio buttons for gender selection
    JLabel date; // Label to display the current date
    JButton b1, b2; // Buttons for adding a new patient and going back
    Choice c1; // Dropdown for selecting room number

    NEW_PATIENT() {
        // Main Frame Settings
        setTitle("New Patient Form"); // Set the title of the frame
        setSize(850, 550); // Set the size of the frame
        setLocation(300, 250); // Set the location of the frame on the screen
        setUndecorated(true); // Remove the default window decorations
        getContentPane().setBackground(new Color(18, 18, 18)); // Set a dark background color for a futuristic look
        setLayout(null); // Set the layout to null for absolute positioning

        // Main Panel
        JPanel panel = new JPanel(); // Create a main panel
        panel.setBounds(5, 5, 840, 540); // Set the position and size of the panel
        panel.setBackground(new Color(25, 25, 25)); // Set a slightly lighter dark background color
        panel.setLayout(null); // Set the layout of the panel to null for absolute positioning
        add(panel); // Add the panel to the frame

        // Logo
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/patient.png")); // Load the logo image
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Resize the image
        ImageIcon imageIcon1 = new ImageIcon(image); // Create a new image icon with the resized image
        JLabel label = new JLabel(imageIcon1); // Create a label to display the image
        label.setBounds(550, 150, 200, 200); // Set the position and size of the label
        panel.add(label); // Add the label to the panel

        // Form Title
        JLabel labelName = new JLabel("NEW PATIENT FORM"); // Create a label for the form title
        labelName.setBounds(118, 11, 260, 53); // Set the position and size of the label
        labelName.setFont(new Font("Inter", Font.BOLD, 25)); // Set the font of the label
        labelName.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(labelName); // Add the label to the panel

        // ID Label and ComboBox
        JLabel labelID = new JLabel("ID :"); // Create a label for the ID type
        labelID.setBounds(35, 76, 200, 20); // Set the position and size of the label
        labelID.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        labelID.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(labelID); // Add the label to the panel

        comboBox = new JComboBox<>(new String[]{"Aadhar Card", "Voter Id", "Driving License"}); // Create a dropdown for selecting ID type
        comboBox.setBounds(271, 73, 190, 28); // Set the position and size of the dropdown
        comboBox.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        comboBox.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        comboBox.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the dropdown
        comboBox.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        panel.add(comboBox); // Add the dropdown to the panel

        // Number Label and TextField
        JLabel labelNumber = new JLabel("Number :"); // Create a label for the number
        labelNumber.setBounds(35, 111, 200, 14); // Set the position and size of the label
        labelNumber.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        labelNumber.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(labelNumber); // Add the label to the panel

        textFieldNumber = new JTextField(); // Create a text field for the number
        textFieldNumber.setBounds(271, 111, 190, 28); // Set the position and size of the text field
        textFieldNumber.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        textFieldNumber.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        textFieldNumber.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        panel.add(textFieldNumber); // Add the text field to the panel

        // Name Label and TextField
        JLabel labelName1 = new JLabel("Name :"); // Create a label for the name
        labelName1.setBounds(35, 151, 200, 14); // Set the position and size of the label
        labelName1.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        labelName1.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(labelName1); // Add the label to the panel

        textName = new JTextField(); // Create a text field for the name
        textName.setBounds(271, 151, 190, 28); // Set the position and size of the text field
        textName.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        textName.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        textName.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        panel.add(textName); // Add the text field to the panel

        // Gender Label and RadioButtons
        JLabel labelGender = new JLabel("Gender :"); // Create a label for the gender
        labelGender.setBounds(35, 191, 200, 14); // Set the position and size of the label
        labelGender.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        labelGender.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(labelGender); // Add the label to the panel

        r1 = new JRadioButton("Male"); // Create a radio button for "Male"
        r1.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the radio button
        r1.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        r1.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        r1.setBounds(271, 191, 80, 15); // Set the position and size of the radio button
        panel.add(r1); // Add the radio button to the panel

        r2 = new JRadioButton("Female"); // Create a radio button for "Female"
        r2.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the radio button
        r2.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        r2.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        r2.setBounds(350, 191, 150, 15); // Set the position and size of the radio button
        panel.add(r2); // Add the radio button to the panel

        // Disease Label and TextField
        JLabel labelDisease = new JLabel("Disease :"); // Create a label for the disease
        labelDisease.setBounds(35, 231, 200, 14); // Set the position and size of the label
        labelDisease.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        labelDisease.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(labelDisease); // Add the label to the panel

        textDisease = new JTextField(); // Create a text field for the disease
        textDisease.setBounds(271, 231, 190, 28); // Set the position and size of the text field
        textDisease.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        textDisease.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        textDisease.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        panel.add(textDisease); // Add the text field to the panel

        // Room Label and Choice
        JLabel labelRoom = new JLabel("Room :"); // Create a label for the room
        labelRoom.setBounds(35, 274, 200, 14); // Set the position and size of the label
        labelRoom.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        labelRoom.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(labelRoom); // Add the label to the panel

        c1 = new Choice(); // Create a dropdown for selecting room number
        try {
            conn c = new conn(); // Create a database connection
            ResultSet resultSet = c.statement.executeQuery("select * from Room"); // Execute the query to fetch room numbers
            while (resultSet.next()) {
                c1.add(resultSet.getString("room_no")); // Add each room number to the dropdown
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }

        c1.setBounds(271, 274, 150, 20); // Set the position and size of the dropdown
        c1.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the dropdown
        c1.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        c1.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(c1); // Add the dropdown to the panel

        // Date Label
        JLabel labelDate = new JLabel("Time :"); // Create a label for the date
        labelDate.setBounds(35, 316, 200, 14); // Set the position and size of the label
        labelDate.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        labelDate.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(labelDate); // Add the label to the panel

        Date date1 = new Date(); // Get the current date and time
        date = new JLabel("" + date1); // Create a label to display the current date and time
        date.setBounds(271, 316, 250, 15); // Set the position and size of the label
        date.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        date.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        panel.add(date); // Add the label to the panel

        // Deposit Label and TextField
        JLabel labelDeposit = new JLabel("Deposit :"); // Create a label for the deposit
        labelDeposit.setBounds(35, 359, 200, 17); // Set the position and size of the label
        labelDeposit.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the label
        labelDeposit.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        panel.add(labelDeposit); // Add the label to the panel

        textFieldDeposit = new JTextField(); // Create a text field for the deposit
        textFieldDeposit.setBounds(271, 359, 190, 28); // Set the position and size of the text field
        textFieldDeposit.setBackground(new Color(25, 25, 25)); // Set the background color to dark
        textFieldDeposit.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
        textFieldDeposit.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        panel.add(textFieldDeposit); // Add the text field to the panel

        // Add Button
        b1 = new JButton("ADD"); // Create an "ADD" button
        b1.setBounds(100, 430, 120, 30); // Set the position and size of the button
        b1.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the button
        b1.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        b1.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        b1.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        b1.addActionListener(this); // Add an action listener to the button
        panel.add(b1); // Add the button to the panel

        // Back Button
        b2 = new JButton("BACK"); // Create a "BACK" button
        b2.setBounds(260, 430, 120, 30); // Set the position and size of the button
        b2.setFont(new Font("Inter", Font.BOLD, 14)); // Set the font of the button
        b2.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
        b2.setForeground(new Color(0, 255, 209)); // Set the text color to dark
        b2.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
        b2.addActionListener(this); // Add an action listener to the button
        panel.add(b2); // Add the button to the panel

        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        new NEW_PATIENT(); // Create a new instance of the NEW_PATIENT class to display the frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) { // Check if the "ADD" button is clicked
            conn c = new conn(); // Create a database connection
            String radioBIN = null; // Variable to hold the selected gender
            if (r1.isSelected()) {
                radioBIN = "Male"; // Set gender to "Male" if the first radio button is selected
            } else if (r2.isSelected()) {
                radioBIN = "Female"; // Set gender to "Female" if the second radio button is selected
            }
            String s1 = (String) comboBox.getSelectedItem(); // Get the selected ID type
            String s2 = textFieldNumber.getText(); // Get the entered number
            String s3 = textName.getText(); // Get the entered name
            String s4 = radioBIN; // Get the selected gender
            String s5 = textDisease.getText(); // Get the entered disease
            String s6 = c1.getSelectedItem(); // Get the selected room number
            String s7 = date.getText(); // Get the current date and time
            String s8 = textFieldDeposit.getText(); // Get the entered deposit

            try {
                // SQL query to insert patient information into the database
                String q = "insert into Patient_Info values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                // SQL query to update the room availability
                String q1 = "update room set Availability = 'Occupied' where room_no =" + s6;
                c.statement.executeUpdate(q); // Execute the insert query
                c.statement.executeUpdate(q1); // Execute the update query
                JOptionPane.showMessageDialog(null, "Added Successfully"); // Show a success message
                setVisible(false); // Hide the current frame
            } catch (Exception E) {
                E.printStackTrace(); // Print any exceptions that occur
            }
        } else {
            setVisible(false); // Hide the current frame if the "BACK" button is clicked
        }
    }
}
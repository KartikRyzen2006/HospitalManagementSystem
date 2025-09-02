package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Reception extends JFrame {

    Reception() {
        // Main Frame Settings
        setTitle("Hospital Management System"); // Set the title of the frame
        setSize(1950, 1090); // Set the size of the frame
        getContentPane().setBackground(new Color(18, 18, 18)); // Set a dark background color for a futuristic look
        setLayout(null); // Set the layout to null for absolute positioning
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the frame is closed

        // Main Panel
        JPanel panel = new JPanel(); // Create a main panel
        panel.setLayout(null); // Set the layout of the panel to null for absolute positioning
        panel.setBounds(5, 160, 1525, 670); // Set the position and size of the panel
        panel.setBackground(new Color(25, 25, 25)); // Set a slightly lighter dark background color
        add(panel); // Add the panel to the frame

        // Header Panel
        JPanel panel1 = new JPanel(); // Create a header panel
        panel1.setLayout(null); // Set the layout of the header panel to null for absolute positioning
        panel1.setBounds(5, 5, 1525, 150); // Set the position and size of the header panel
        panel1.setBackground(new Color(25, 25, 25)); // Set a matching dark background color
        add(panel1); // Add the header panel to the frame

        // Logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hor1-removebg-preview.png")); // Load the logo image
        Image image = i1.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH); // Resize the image
        ImageIcon i2 = new ImageIcon(image); // Create a new image icon with the resized image
        JLabel label = new JLabel(i2); // Create a label to display the image
        label.setBounds(1150, -15, 210, 210); // Set the position and size of the label
        panel1.add(label); // Add the label to the header panel

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/15587-removebg-preview.png")); // Load another image
        Image image1 = i3.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH); // Resize the image
        ImageIcon i4 = new ImageIcon(image1); // Create a new image icon with the resized image
        JLabel label1 = new JLabel(i4); // Create a label to display the image
        label1.setBounds(10, 150, 300, 300); // Set the position and size of the label
        panel.add(label1); // Add the label to the main panel

        // Button Styling
        Font buttonFont = new Font("Arial", Font.BOLD, 14); // Set the font for the buttons
        Color buttonColor = new Color(0, 255, 209); // Set the background color to neon cyan for a futuristic look
        Color buttonHoverColor = new Color(0, 200, 180); // Set the hover color to a slightly darker neon cyan
        Color textColor = new Color(255, 255, 255); // Set the text color to white for contrast

        // Add New Patient Button
        JButton btn1 = createStyledButton("Add New Patient", 30, 15, buttonFont, buttonColor, buttonHoverColor, textColor); // Create a styled button
        btn1.addActionListener(e -> new NEW_PATIENT()); // Add an action listener to open the NEW_PATIENT form
        panel1.add(btn1); // Add the button to the header panel

        // Room Button
        JButton btn2 = createStyledButton("Room", 30, 58, buttonFont, buttonColor, buttonHoverColor, textColor); // Create a styled button
        btn2.addActionListener(e -> new Room()); // Add an action listener to open the Room form
        panel1.add(btn2); // Add the button to the header panel

        // Department Button
        JButton btn3 = createStyledButton("Department", 30, 100, buttonFont, buttonColor, buttonHoverColor, textColor); // Create a styled button
        btn3.addActionListener(e -> new Department()); // Add an action listener to open the Department form
        panel1.add(btn3); // Add the button to the header panel

        // All Employee Info Button
        JButton btn4 = createStyledButton("All Employee Info", 270, 15, buttonFont, buttonColor, buttonHoverColor, textColor); // Create a styled button
        btn4.addActionListener(e -> new Employee_info()); // Add an action listener to open the Employee_info form
        panel1.add(btn4); // Add the button to the header panel

        // Patient Info Button
        JButton btn5 = createStyledButton("Patient Info", 270, 58, buttonFont, buttonColor, buttonHoverColor, textColor); // Create a styled button
        btn5.addActionListener(e -> new ALL_Patient_Info()); // Add an action listener to open the ALL_Patient_Info form
        panel1.add(btn5); // Add the button to the header panel

        // Patient Discharge Button
        JButton btn6 = createStyledButton("Patient Discharge", 270, 100, buttonFont, buttonColor, buttonHoverColor, textColor); // Create a styled button
        btn6.addActionListener(e -> new patient_discharge()); // Add an action listener to open the patient_discharge form
        panel1.add(btn6); // Add the button to the header panel

        // Update Patient Details Button
        JButton btn7 = createStyledButton("Update Patient Details", 510, 15, buttonFont, buttonColor, buttonHoverColor, textColor); // Create a styled button
        btn7.addActionListener(e -> new update_patient_details()); // Add an action listener to open the update_patient_details form
        panel1.add(btn7); // Add the button to the header panel

        // Hospital Ambulance Button
        JButton btn8 = createStyledButton("Hospital Ambulance", 510, 58, buttonFont, buttonColor, buttonHoverColor, textColor); // Create a styled button
        btn8.addActionListener(e -> new Ambulance()); // Add an action listener to open the Ambulance form
        panel1.add(btn8); // Add the button to the header panel

        // Search Room Button
        JButton btn9 = createStyledButton("Search Room", 510, 100, buttonFont, buttonColor, buttonHoverColor, textColor); // Create a styled button
        btn9.addActionListener(e -> new SearchRoom()); // Add an action listener to open the SearchRoom form
        panel1.add(btn9); // Add the button to the header panel

        // Logout Button
        JButton btn10 = createStyledButton("Logout", 750, 58, buttonFont, buttonColor, buttonHoverColor, textColor); // Create a styled button
        btn10.addActionListener(e -> {
            setVisible(false); // Hide the current frame
            new login(); // Open the login frame
        });
        panel1.add(btn10); // Add the button to the header panel

        setVisible(true); // Make the frame visible
    }

    private JButton createStyledButton(String text, int x, int y, Font font, Color color, Color hoverColor, Color textColor) {
        JButton button = new JButton(text); // Create a button with the given text
        button.setBounds(x, y, 200, 30); // Set the position and size of the button
        button.setFont(font); // Set the font of the button
        button.setBackground(color); // Set the background color of the button
        button.setForeground(textColor); // Set the text color of the button
        button.setFocusPainted(false); // Remove the focus border
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 150, 150), 2)); // Set a neon border

        // Add mouse listeners for hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(hoverColor); // Change background color on hover
                button.setBorder(BorderFactory.createLineBorder(new Color(0, 200, 200), 2)); // Brighter border on hover
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(color); // Reset background color when not hovered
                button.setBorder(BorderFactory.createLineBorder(new Color(0, 150, 150), 2)); // Reset border
            }
        });

        return button; // Return the styled button
    }

    public static void main(String[] args) {
        new Reception(); // Create a new instance of the Reception class to display the frame
    }
}
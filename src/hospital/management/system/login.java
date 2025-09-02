package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
  // Declare the components used in the login form
  JTextField textField; // Text field for username
  JPasswordField passwordField; // Password field for password
  JButton b1, b2; // Buttons for login and cancel

  // Constructor to initialize the login frame
  login() {
    // Main Frame Settings
    setTitle("Hospital Management System - Login"); // Set the title of the frame
    setSize(750, 300); // Set the size of the frame
    setLocation(400, 270); // Set the location of the frame on the screen
    getContentPane().setBackground(new Color(18, 18, 18)); // Set a dark background color
    setLayout(null); // Set the layout to null for absolute positioning
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the Close application on closing the frame

    // Username Label
    JLabel namelabel = new JLabel("Username"); // Create a label for the username
    namelabel.setBounds(40, 20, 100, 30); // Set the position and size of the label
    namelabel.setFont(new Font("Inter", Font.BOLD, 19)); // Set the font of the label
    namelabel.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
    add(namelabel); // Add the label to the frame

    // Password Label
    JLabel password = new JLabel("Password"); // Create a label for the password
    password.setBounds(40, 70, 100, 30); // Set the position and size of the label
    password.setFont(new Font("Inter", Font.BOLD, 19)); // Set the font of the label
    password.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
    add(password); // Add the label to the frame

    // Username Text Field
    textField = new JTextField(); // Create a text field for the username
    textField.setBounds(150, 20, 150, 30); // Set the position and size of the text field
    textField.setFont(new Font("Inter", Font.PLAIN, 20)); // Set the font of the text field
    textField.setBackground(new Color(25, 25, 25)); // Set the background color to dark
    textField.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
    textField.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
    add(textField); // Add the text field to the frame

    // Password Field
    passwordField = new JPasswordField(); // Create a password field for the password
    passwordField.setBounds(150, 70, 150, 30); // Set the position and size of the password field
    passwordField.setFont(new Font("Inter", Font.PLAIN, 20)); // Set the font of the password field
    passwordField.setBackground(new Color(25, 25, 25)); // Set the background color to dark
    passwordField.setForeground(new Color(0, 255, 209)); // Set the text color to neon cyan
    passwordField.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
    add(passwordField); // Add the password field to the frame

    // Logo
    ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/hor-removebg-preview.png")); // Load the logo image
    Image i1 = imageIcon.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT); // Resize the image
    ImageIcon imageIcon1 = new ImageIcon(i1); // Create a new image icon with the resized image
    JLabel label = new JLabel(imageIcon1); // Create a label to display the image
    label.setBounds(320, -20, 400, 300); // Set the position and size of the label
    add(label); // Add the label to the frame

    // Login Button
    b1 = new JButton("Login"); // Create a button for login
    b1.setBounds(40, 140, 120, 30); // Set the position and size of the button
    b1.setFont(new Font("Inter", Font.BOLD, 15)); // Set the font of the button
    b1.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
    b1.setForeground(new Color(0, 255, 209)); // Set the text color to dark
    b1.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
    b1.addActionListener(this); // Add an action listener to the button
    add(b1); // Add the button to the frame

    // Cancel Button
    b2 = new JButton("Cancel"); // Create a button for cancel
    b2.setBounds(180, 140, 120, 30); // Set the position and size of the button
    b2.setFont(new Font("Inter", Font.BOLD, 15)); // Set the font of the button
    b2.setBackground(new Color(0, 255, 209)); // Set the background color to neon cyan
    b2.setForeground(new Color(0, 255, 209)); // Set the text color to dark
    b2.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 209), 2)); // Set a neon border
    b2.addActionListener(this); // Add an action listener to the button
    add(b2); // Add the button to the frame

    setVisible(true); // Make the frame visible
  }

  // Main method to run the application
  public static void main(String[] args) {
    new login(); // Create a new instance of the login class
  }

  // ActionPerformed method to handle button clicks
  @Override
  public void actionPerformed(ActionEvent e) {
    // Check if the login button is clicked
    if (e.getSource() == b1) {
      try {
        conn c = new conn(); // Create a connection to the database
        String user = textField.getText(); // Get the username from the text field
        String Pass = new String(passwordField.getPassword()); // Get the password from the password field

        // SQL query to check if the username and password match
        String q = "select * from login where ID = '" + user + "' and PW = '" + Pass + "'";
        ResultSet resultSet = c.statement.executeQuery(q); // Execute the query

        // Check if the query returns a result
        if (resultSet.next()) {
          new Reception(); // If valid, open the reception page
          setVisible(false); // Hide the login frame
        } else {
          JOptionPane.showMessageDialog(null, "Invalid Login"); // Show an error message if invalid
        }
      } catch (Exception E) {
        E.printStackTrace(); // Print any exceptions that occur
      }
    } else {
      // If the cancel button is clicked, exit the application
      System.exit(10);
    }
  }
}
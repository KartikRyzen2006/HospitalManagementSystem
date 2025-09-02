package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection connection; // Variable to hold the database connection
    Statement statement; // Variable to hold the SQL statement object

    public conn() {
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital_management_system", // Database URL
                    "root", // Database username
                    "kartik234" // Database password
            );

            // Create a statement object to execute SQL queries
            statement = connection.createStatement();
        } catch (Exception e) {
            // Print any exceptions that occur during the connection process
            e.printStackTrace();
        }
    }
}

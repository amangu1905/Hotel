package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Data Access Object for managing hotel guest payments.
 * Supports insertion of payment records with basic validation and error handling.
 */
public class PaymentDAO implements AutoCloseable {
    private Connection conn;

    /**
     * Establishes connection to the hotelmanagementsystem database.
     * @throws SQLException if database connection fails
     */
    public PaymentDAO() throws SQLException {
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotelmanagementsystem",
                "root",
                "Divyan@2006"
            );
        } catch (SQLException e) {
            throw new SQLException("Failed to connect to the hotel database", e);
        }
    }

    /**
     * Records a new payment for a guest.
     *
     * @param guestId ID of the guest
     * @param serviceType Type of service (e.g., Room, Food, Laundry)
     * @param amount Amount paid
     * @throws SQLException if there is an issue executing the insert
     * @throws IllegalArgumentException if input validation fails
     */
    public void addPayment(String guestId, String serviceType, double amount)
            throws SQLException, IllegalArgumentException {

        if (guestId == null || guestId.trim().isEmpty()) {
            throw new IllegalArgumentException("Guest ID cannot be empty");
        }

        if (serviceType == null || serviceType.trim().isEmpty()) {
            throw new IllegalArgumentException("Service type cannot be empty");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }

        String query = "INSERT INTO payments (guest_id, date, service_type, amount) VALUES (?, NOW(), ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, guestId);
            stmt.setString(2, serviceType);
            stmt.setDouble(3, amount);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Failed to record payment", e);
        }
    }

    /**
     * Closes the database connection.
     * @throws SQLException if an error occurs during closing
     */
    @Override
    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}

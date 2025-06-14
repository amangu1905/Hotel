package Hotel.Management.System;

import java.sql.*;

/**
 * Data Access Object for user authentication and registration.
 * Supports:
 * - Secure login
 * - New user registration
 * - Role-based user support (admin/guest)
 */
public class UserDAO implements AutoCloseable {
    private Connection conn;

    public UserDAO() throws SQLException {
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotelmanagementsystem",
                "root",
                "Divyan@2006"
            );
        } catch (SQLException e) {
            throw new SQLException("Failed to connect to database", e);
        }
    }

    /**
     * Authenticates a user based on username and password
     * @param username user's login name
     * @param password plain text password (should be hashed in production)
     * @return true if valid credentials, false otherwise
     * @throws SQLException on query error
     */
    public boolean login(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);  // Replace with hashed password if needed
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    /**
     * Registers a new user.
     * @param username username to register
     * @param password password to store
     * @param role user role (e.g., "guest" or "admin")
     * @return true if registration is successful
     * @throws SQLException if username already exists or DB error
     */
    public boolean registerUser(String username, String password, String role) throws SQLException {
        if (userExists(username)) {
            throw new SQLException("Username already exists");
        }

        String insert = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(insert)) {
            stmt.setString(1, username);
            stmt.setString(2, password); // You can hash this before storing
            stmt.setString(3, role);
            return stmt.executeUpdate() > 0;
        }
    }

    /**
     * Checks if a user already exists
     * @param username to check
     * @return true if user exists
     * @throws SQLException on DB error
     */
    public boolean userExists(String username) throws SQLException {
        String query = "SELECT username FROM users WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    /**
     * Gets the role of a user
     * @param username username to check
     * @return role (e.g., "admin", "guest")
     * @throws SQLException if not found or DB error
     */
    public String getUserRole(String username) throws SQLException {
        String query = "SELECT role FROM users WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("role");
                } else {
                    throw new SQLException("User not found");
                }
            }
        }
    }

    @Override
    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}

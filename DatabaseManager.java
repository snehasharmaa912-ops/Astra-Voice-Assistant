import java.sql.*;
public class DatabaseManager {
    private static Connection conn;    
    public static void init() throws SQLException {
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/astra", "root", "password"
        );
        String sql = "CREATE TABLE IF NOT EXISTS history (id INT AUTO_INCREMENT PRIMARY KEY, command VARCHAR(100), success BOOLEAN, time TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
        conn.createStatement().execute(sql);
    }    
    public static void logCommand(String command, boolean success) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO history(command, success) VALUES (?, ?)");
            ps.setString(1, command);
            ps.setBoolean(2, success);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("DB Error: " + e.getMessage());
        }
    }    
    public static ResultSet getHistory() throws SQLException {
        return conn.createStatement().executeQuery("SELECT * FROM history ORDER BY time DESC LIMIT 50");
    }
}

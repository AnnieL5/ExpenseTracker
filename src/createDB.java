import java.sql.*;
import javax.swing.JOptionPane;

public class createDB {
    // public static void main(String[] args) throws Exception {
    // try {
    // String url = "jdbc:mysql://localhost:3306/";
    // // String url = "jdbc:mysql://localhost:3306/expenseTracker";
    // String databaseName = "localhost";
    // String userName = "root";
    // String password = "SQL.mtbt0511";

    // Connection connection = DriverManager.getConnection(url, userName, password);

    // String sql = "CREATE DATABASE " + databaseName;

    // Statement statement = connection.createStatement(); // connect to database
    // statement.executeUpdate(sql);

    // /*
    // results = statement.executeUpdate(sql);
    // while(result.next() != false){
    // output = result.getString();
    // }

    // */
    // statement.close();
    // JOptionPane.showMessageDialog(null, databaseName + " Database has been
    // created successfully",
    // "System Message", JOptionPane.INFORMATION_MESSAGE);

    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    private final String url = "jdbc:mysql://localhost:3306/expenseTracker";
    private final String userName = "root";
    private final String password = "PASSWORD";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }

    public void createDatabase() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/", userName, password);
                Statement stmt = conn.createStatement()) {

            String sql = "CREATE DATABASE IF NOT EXISTS expenseTracker";
            stmt.executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Database created successfully",
                    "System Message",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS transactions (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    amount DECIMAL(10,2) NOT NULL,
                    date DATE NOT NULL,
                    description VARCHAR(255)
                )
                """;

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Table created successfully",
                    "System Message",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertTransaction(double amount, String date, String note) {

        String sql = "INSERT INTO transactions (amount, date, description) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, amount);
            pstmt.setString(2, date);
            pstmt.setString(3, note);

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Transaction added to database",
                    "System Message",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void retrieveTransactions() {

        String sql = "SELECT * FROM transactions";

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(sql)) {

            while (result.next()) {
                int id = result.getInt("id");
                double amount = result.getDouble("amount");
                Date date = result.getDate("date");
                String desc = result.getString("description");

                System.out.println(id + " | " + amount + " | " + date + " | " + desc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

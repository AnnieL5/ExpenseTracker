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

    private static final String url = "jdbc:mysql://localhost:3306/expenseTracker";
    private static final String userName = "root";
    private static final String password = "SQL.mtbt0511";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }

    public static void createDatabase() {
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

    public static void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS transactions (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    type ENUM('INCOME', 'EXPENSE') NOT NULL,
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

    public static void insertTransaction(String type, float amount, String date, String note) {

        String sql = "INSERT INTO transactions (type, amount, date, description) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, type);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, date);
            pstmt.setString(4, note);

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Transaction added to database",
                    "System Message",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String retrieveTransactions() {

        String sql = "SELECT * FROM transactions";
        String output = "";

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(sql)) {

            while (result.next()) {
                int id = result.getInt("id");
                String type = result.getString("type");
                double amount = result.getDouble("amount");
                Date date = result.getDate("date");
                String desc = result.getString("description");

                output += "ID: " + id + " | Type: " + type + " | Amount: " + amount + " | Date: " + date
                        + " | Description: " + desc
                        + "\n\n";
                // System.out.println(id + " | " + amount + " | " + date + " | " + desc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output;
    }

    public static float retrieveNetMoney() {

        String sql = "SELECT amount FROM transactions";
        float sum = 0;
        double amount;

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(sql)) {

            while (result.next()) {
                amount = result.getDouble("amount");
                sum += amount;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sum;
    }

    public static void resetDB() {

        String sql = "TRUNCATE TABLE transactions";

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Table cleared successfully",
                    "System Message",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Delete: TRUNCATE TABLE table_name;
     * DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';
     */

}

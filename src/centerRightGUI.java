import java.awt.*;
import javax.swing.*;

public class centerRightGUI extends JPanel {
    private JLabel historyLabel;
    private static JTextArea historyText;

    public centerRightGUI() {
        // setLayout(new GridBagLayout());
        setOpaque(true);
        setBackground(new Color(204, 255, 204));
        setLayout(new BorderLayout(10, 10));

        historyLabel = new JLabel("Transaction History", SwingConstants.CENTER);
        historyLabel.setFont(new Font("SansSerif", Font.BOLD, 22));

        historyText = new JTextArea("Text");
        historyText.setFont(new Font("Monospaced", Font.PLAIN, 15));
        historyText.setLineWrap(true); // Wraps lines that are too long for the component's width
        historyText.setWrapStyleWord(true); // Ensures wrapping occurs at word boundaries
        historyText.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(historyText);
        scrollPane.setPreferredSize(new Dimension(500, 550));

        add(historyLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        updateHistory();
    }

    public static void updateHistory() {
        // Fetch history from SQL
        String str = createDB.retrieveTransactions();
        historyText.setText(str);
    }
}

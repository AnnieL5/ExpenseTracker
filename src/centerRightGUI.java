import java.awt.*;
import javax.swing.*;

public class centerRightGUI extends JPanel {
    private JLabel historyLabel;
    private static JTextArea historyText;

    public centerRightGUI() {
        // setLayout(new GridBagLayout());
        historyLabel = new JLabel("History");
        historyText = new JTextArea("Text");
        historyText.setLineWrap(true); // Wraps lines that are too long for the component's width
        historyText.setWrapStyleWord(true); // Ensures wrapping occurs at word boundaries
        historyText.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(historyText);
        scrollPane.setPreferredSize(new Dimension(400, 500));

        this.add(historyLabel);
        this.add(scrollPane);

        updateHistory();
    }

    public static void updateHistory() {
        // Fetch history from SQL
        String str = createDB.retrieveTransactions();
        historyText.setText(str);
    }
}

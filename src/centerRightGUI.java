import java.awt.*;
import javax.swing.*;

public class centerRightGUI extends JPanel{
    private JLabel historyLabel;
    private JLabel historyText;
    public centerRightGUI(){
        historyLabel = new JLabel("History");
        historyText = new JLabel("Text");
        setLayout(new GridBagLayout());

        this.add(historyLabel);
        this.add(historyText);
    }

    public static void updateHistory(){
        //Fetch history from SQL
    }
}

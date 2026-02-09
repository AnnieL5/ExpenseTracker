import java.awt.*;
import javax.swing.*;

public class topGUI extends JPanel{
    private JButton addButton;
    static JLabel infoText;

    public topGUI(){
        setBounds(0,0,400,400);
        setLayout(new FlowLayout());

        addButton = new JButton("Add");
        infoText = new JLabel();
        updateInfoText();

        this.add(addButton);
        this.add(infoText);

    }

    public static void updateInfoText(){
        infoText.setText("You lost money!");
    }
}

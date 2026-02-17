import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class topGUI extends JPanel implements ActionListener {
    private JButton addButton;
    static JLabel infoText;
    private addGUI addgui;

    private static float netMoney;

    public topGUI() {
        setBounds(0, 0, 400, 400);
        setLayout(new FlowLayout());

        addButton = new JButton("Add transaction");
        infoText = new JLabel();
        initNetMoney();

        addgui = new addGUI();

        addButton.addActionListener(this);

        this.add(addButton);
        this.add(infoText);

    }

    public void initNetMoney() {
        netMoney = createDB.retrieveNetMoney();
        infoText.setText("Current Balance: " + netMoney);
    }

    public static void updateInfoText(float amount) {
        netMoney += amount;
        infoText.setText("Current Balance: " + netMoney);
    }

    public static void resetInfoText(){
        netMoney = createDB.retrieveNetMoney();
        infoText.setText("Current Balance: " + netMoney);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        addgui.setVisible(true);
    }
}

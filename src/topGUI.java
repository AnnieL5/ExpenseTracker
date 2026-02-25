import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class topGUI extends JPanel implements ActionListener {
    private JButton addButton;
    static JLabel infoText;
    private addGUI addgui;

    static int needBudget;
    static int wantBudget;
    static int saveBudget;

    public static float netMoney = 0;
    public static int netBuget;
    private static float netNeed;
    private static float netWant;
    private static float netSave;

    public topGUI() {
        // setBounds(0, 0, 400, 400);
        setOpaque(true);
        setBackground(new Color(204, 255, 204));
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        Font bigFont = new Font("SansSerif", Font.BOLD, 15);

        addButton = new JButton("Add transaction");
        addButton.setFont(bigFont);
        addButton.setFocusPainted(false);

        infoText = new JLabel();
        infoText.setFont(new Font("SansSerif", Font.BOLD, 15));
        initNetMoney();

        addgui = new addGUI();

        addButton.addActionListener(this);

        this.add(addButton);
        this.add(infoText);

    }

    public static void initNetMoney() {
        netMoney = createDB.retrieveNetMoney();
        netBuget = createDB.retrieveNetBudget();

        needBudget = budgetGUI.needP * netBuget / 100;
        wantBudget = budgetGUI.wantP * netBuget / 100;
        saveBudget = budgetGUI.saveP * netBuget / 100;

        netNeed = -createDB.retrieveNetMoney("NEED");
        netWant = -createDB.retrieveNetMoney("WANT");
        netSave = -createDB.retrieveNetMoney("SAVING");

        if (createDB.retrieveNetMoney("NEED") == 0) {
            netNeed = 0;
        }
        if (createDB.retrieveNetMoney("WANT") == 0) {
            netWant = 0;
        }
        if (createDB.retrieveNetMoney("SAVING") == 0) {
            netSave = 0;
        }

        infoText.setText(
                "Current Balance: " + netMoney +
                        ", Need: " + netNeed + "/" + needBudget +
                        ", Want: " + netWant + "/" + wantBudget +
                        ", Saving: " + netSave + "/" + saveBudget);
        // if (netMoney < 0){
        // JOptionPane.showMessageDialog(null,
        // "WARNING: Negative Balance",
        // "System Message",
        // JOptionPane.WARNING_MESSAGE);
        // }
    }

    public static void updateInfoText(float amount) {
        netMoney += amount;
        infoText.setText("Current Balance: " + netMoney);
        // if (netMoney < 0){
        // JOptionPane.showMessageDialog(null,
        // "WARNING: Negative Balance",
        // "System Message",
        // JOptionPane.WARNING_MESSAGE);
        // }
    }

    public static void resetInfoText() {
        netMoney = createDB.retrieveNetMoney();
        infoText.setText("Current Balance: " + netMoney);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addgui.setVisible(true);
    }
}

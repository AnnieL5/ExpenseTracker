import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class rightGUI extends JPanel implements ActionListener {
    JButton addBudgetbutton;
    JButton resetDBbutton;
    JButton deleteDBbutton;

    deleteGUI deletegui;

    public rightGUI() {
        setOpaque(true);
        setBackground(new Color(204, 255, 204));
        setLayout(new GridLayout(3, 1, 15, 15));

        Font buttonFont = new Font("SansSerif", Font.BOLD, 15);

        deletegui = new deleteGUI();

        addBudgetbutton = new JButton("Add Budget");
        addBudgetbutton.setFont(buttonFont);
        addBudgetbutton.addActionListener(this);
        this.add(addBudgetbutton);

        deleteDBbutton = new JButton("Delete transaction");
        deleteDBbutton.setFont(buttonFont);
        deleteDBbutton.addActionListener(this);
        this.add(deleteDBbutton);

        resetDBbutton = new JButton("Reset Database");
        resetDBbutton.setFont(buttonFont);
        resetDBbutton.addActionListener(this);
        this.add(resetDBbutton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetDBbutton) {
            int response = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to reset the database?",
                    "Confirm Reset",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                createDB.resetDB();
                createDB.createTable();
                centerRightGUI.updateHistory();
                topGUI.initNetMoney();
            }
        } else if (e.getSource() == deleteDBbutton) {
            deletegui.setVisible(true);
        } else if (e.getSource() == addBudgetbutton) {
            Main.budgetgui.setVisible(true);
        }
    }
}
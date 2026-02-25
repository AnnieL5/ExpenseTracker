import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class rightGUI extends JPanel implements ActionListener {
    JButton addBudgetbutton;
    JButton resetDBbutton;
    JButton deleteDBbutton;

    deleteGUI deletegui;

    public rightGUI() {
        setLayout(new GridLayout(3, 1));
        deletegui = new deleteGUI();

        addBudgetbutton = new JButton("Add Budget");
        addBudgetbutton.addActionListener(this);
        this.add(addBudgetbutton);

        resetDBbutton = new JButton("Reset Database");
        resetDBbutton.addActionListener(this);
        this.add(resetDBbutton);

        deleteDBbutton = new JButton("Delete transaction");
        deleteDBbutton.addActionListener(this);
        this.add(deleteDBbutton);
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
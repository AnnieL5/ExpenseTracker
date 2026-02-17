import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class addGUI extends JFrame implements ItemListener, ActionListener {

    final static String EXPENSE = "Add Expense";
    final static String INCOME = "Add income";

    JPanel cards;
    JPanel card1;
    JPanel card2;
    JTextField amountField;
    JTextField dateField;
    JTextField noteField;
    JPanel comboBoxPane;
    JComboBox cb;

    JButton submitButton;

    public addGUI() {
        comboBoxPane = new JPanel();
        String comboBoxItems[] = { EXPENSE, INCOME };
        cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        // Create cards
        card1 = new JPanel(); // expense new GridLayout(4, 2)
        amountField = new JTextField(20);
        dateField = new JTextField(15);
        noteField = new JTextField(20);

        card1.add(new JLabel("Amount"));

        card1.add(amountField);

        card1.add(new JLabel("Date(YYYY-MM-DD):"));
        card1.add(dateField);

        card1.add(new JLabel("Note:"));
        card1.add(noteField);

        submitButton = new JButton("Add");
        submitButton.addActionListener(this);
        card1.add(submitButton);

        // card2 = new JPanel();
        // card2.add(new JTextField("Amount: ", 20));

        // Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(comboBoxPane);
        cards.add(card1);
        // cards.add(card2, INCOME);

        this.setSize(300, 400);

        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(cards, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.setVisible(false);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }

    // public void changeVisibility(boolean visible){
    // if(visible){
    // this.setVisible(true);
    // }else{
    // this.setVisible(false);
    // }
    // }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {

            float amount = Float.parseFloat(amountField.getText());
            String date = dateField.getText();
            String note = noteField.getText();

            String type = (String) cb.getSelectedItem();

            if (type.equals(EXPENSE)) {
                type = "EXPENSE";
                amount = -amount;
            } else if (type.equals(INCOME)) {
                type = "INCOME";
            }

            createDB.insertTransaction(type, amount, date, note);

            centerRightGUI.updateHistory();

            JOptionPane.showMessageDialog(null, "Transaction added successfully!");
            this.setVisible(false);
        }
    }

}
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class addGUI extends JFrame implements ItemListener, ActionListener {

    final static String EXPENSE = "Add Expense";
    final static String INCOME = "Add income";

    final static String NEED = "  Need                ";
    final static String WANT = "  Want                      ";
    final static String SAVING = "  Saving                 ";
    final static String OTHER = "  Income - Budget for all                  ";

    JPanel cards;
    JPanel card1;
    JPanel card2;
    JTextField amountField;
    JTextField dateField;
    JTextField noteField;
    JPanel comboBoxPane;
    JComboBox cb;
    JComboBox typecb;

    JButton submitButton;

    public addGUI() {

        Color lightGreen = new Color(204, 255, 204);
        Font largeFont = new Font("SansSerif", Font.PLAIN, 15);
        Font labelFont = new Font("SansSerif", Font.BOLD, 15);

        this.setLayout(new BorderLayout(15, 15));
        this.getContentPane().setBackground(lightGreen);

        comboBoxPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        comboBoxPane.setBackground(lightGreen);

        String comboBoxItems[] = { EXPENSE, INCOME };
        cb = new JComboBox(comboBoxItems);
        cb.setFont(largeFont);
        cb.setPreferredSize(new Dimension(200, 35));
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        // Create cards
        card1 = new JPanel(new GridLayout(5, 2, 15, 15));
        card1.setBackground(lightGreen);
        card1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        amountField = new JTextField(20);
        amountField.setFont(largeFont);

        dateField = new JTextField("2026-02-25", 20);
        dateField.setFont(largeFont);

        noteField = new JTextField(20);
        noteField.setFont(largeFont);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(labelFont);

        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setFont(labelFont);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setFont(labelFont);

        JLabel noteLabel = new JLabel("Note:");
        noteLabel.setFont(labelFont);

        String typeCBItems[] = { NEED, WANT, SAVING, OTHER };
        typecb = new JComboBox(typeCBItems);
        typecb.setFont(largeFont);
        typecb.setPreferredSize(new Dimension(200, 35));
        typecb.setEditable(false);
        typecb.addItemListener(this);

        submitButton = new JButton("Add Transaction");
        submitButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        submitButton.setPreferredSize(new Dimension(200, 45));
        submitButton.addActionListener(this);

        // card2 = new JPanel();
        // card2.add(new JTextField("Amount: ", 20));

        // Create the panel that contains the "cards".
        card1.add(amountLabel);
        card1.add(amountField);

        card1.add(dateLabel);
        card1.add(dateField);

        card1.add(typeLabel);
        card1.add(typecb);

        card1.add(noteLabel);
        card1.add(noteField);

        card1.add(new JLabel()); // empty cell for spacing
        card1.add(submitButton);

        // ===== Cards Panel =====
        cards = new JPanel(new CardLayout());
        cards.setBackground(lightGreen);
        cards.add(card1, EXPENSE);

        // Add to frame
        this.add(comboBoxPane, BorderLayout.NORTH);
        this.add(cards, BorderLayout.CENTER);
        // cards.add(card2, INCOME);

        this.setSize(450, 400);
        this.setLocationRelativeTo(null);
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

            String cat = typecb.getSelectedItem().toString();

            if (cat.equals(NEED)) {
                cat = "NEED";
            } else if (cat.equals(WANT)) {
                cat = "WANT";
            } else if (cat.equals(SAVING)) {
                cat = "SAVING";
            }

            createDB.insertTransaction(type, amount, date, cat, note);
            topGUI.initNetMoney();
            // topGUI.updateInfoText(amount);

            centerRightGUI.updateHistory();

            JOptionPane.showMessageDialog(null, "Transaction added successfully!");
            this.setVisible(false);

            amountField.setText("");
            dateField.setText("");
            noteField.setText("");

        }
    }

}
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class addGUI extends JPanel implements ItemListener{
    final static String EXPENSE = "Add Expense";
    final static String INCOME = "Add income";

    JPanel cards;
    JPanel card1;
    JPanel card2;
    JPanel comboBoxPane;
    JComboBox cb;
    
    public addGUI(){
        comboBoxPane = new JPanel();
        String comboBoxItems[] = {EXPENSE, INCOME};
        cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        //Create cards
        card1 = new JPanel(); //expense
        card1.add(new JTextField("Amount: ", 20));
        
        card2 = new JPanel();
        card2.add(new JTextField("Amount: ", 20));
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, EXPENSE);
        cards.add(card2, INCOME);
        
        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(cards, BorderLayout.CENTER);
    }
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
}
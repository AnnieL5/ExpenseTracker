import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class addGUI extends JFrame implements ItemListener, ActionListener{
    final static String EXPENSE = "Add Expense";
    final static String INCOME = "Add income";

    JPanel cards;
    JPanel card1;
    JPanel card2;
    JPanel comboBoxPane;
    JComboBox cb;

    JButton submitButton;
    
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
        card1.add(new JTextField("Date: ", 20));
        card1.add(new JTextField("Note: ", 20));

        submitButton = new JButton("Add");
        card1.add(submitButton);
        
        // card2 = new JPanel();
        // card2.add(new JTextField("Amount: ", 20));
        
        //Create the panel that contains the "cards".
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
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    // public void changeVisibility(boolean visible){
    //     if(visible){
    //         this.setVisible(true);
    //     }else{
    //         this.setVisible(false);
    //     }
    // }
    @Override
    public void actionPerformed(ActionEvent e){
        this.setVisible(false);
    }
}
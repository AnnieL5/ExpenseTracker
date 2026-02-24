import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class budgetGUI extends JFrame implements ActionListener {
    // public class budgetGUI extends JFrame {
    private JLabel heading;
    private JLabel description;

    private JSlider needSlider;
    private JSlider wantSlider;
    private JSlider saveSlider;

    private JTextField budgetTF;

    private JTextField needTF;
    private JTextField wantTF;
    private JTextField saveTF;

    private JButton submitButton;

    static int needP;
    static int wantP;
    static int saveP;


    public budgetGUI() {
        this.setLayout(new java.awt.FlowLayout());

        heading = new JLabel("Enter your budget");
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(heading);

        description = new JLabel(
                "<html>Please enter your budget for the month.<br> The amount entered will be split into sections (needs, <br> wants, save) based on your preference.</html>");
        description.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(description);

        // this.add(new JLabel("<html> <br> </html>"));

        this.add(new JLabel("Budget ($): "));
        budgetTF = new JTextField(30);
        budgetTF.addActionListener(this);
        this.add(budgetTF);

        // this.add(new JLabel("\n"));

        // Need
        this.add(new JLabel("Need (%): "));
        needSlider = new JSlider(0, 100);
        needTF = new JTextField(String.valueOf(needSlider.getValue()), 15);
        setupSlider(needSlider, needTF);
        System.out.println("Here");

        this.add(needSlider);
        this.add(needTF);

        // Want
        this.add(new JLabel("Want (%): "));
        wantSlider = new JSlider(0, 100);
        wantTF = new JTextField(String.valueOf(wantSlider.getValue()), 15);
        setupSlider(wantSlider, wantTF);

        this.add(wantSlider);
        this.add(wantTF);

        // Savings
        this.add(new JLabel("Saving (%): "));
        saveSlider = new JSlider(0, 100);
        saveTF = new JTextField(String.valueOf(saveSlider.getValue()), 15);
        setupSlider(saveSlider, saveTF);

        this.add(saveSlider);
        this.add(saveTF);

        // this.add(new JLabel("\n"));

        submitButton = new JButton("Done");
        submitButton.addActionListener(this);
        this.add(submitButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(450, 450);

        // needTF.addActionListener(e -> {
        // try {
        // int value = Integer.parseInt(needTF.getText());
        // if (value >= needSlider.getMinimum() && value <= needSlider.getMaximum()) {
        // needSlider.setValue(value);
        // } else {
        // // Optional: Reset if out of range
        // needTF.setText(String.valueOf(needSlider.getValue()));
        // }
        // } catch (NumberFormatException ex) {
        // // Reset if invalid input
        // needTF.setText(String.valueOf(needSlider.getValue()));
        // }
        // });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == needTF) {
            textFieldAction(needSlider, needTF);
        } else if (e.getSource() == wantTF) {
            textFieldAction(wantSlider, wantTF);
        } else if (e.getSource() == saveTF) {
            textFieldAction(saveSlider, saveTF);
        } else if (e.getSource() == submitButton) {
            needP = Integer.parseInt(needTF.getText());
            wantP = Integer.parseInt(wantTF.getText());
            saveP = Integer.parseInt(saveTF.getText());

            int budget = Math.round(Float.parseFloat(budgetTF.getText()));

            topGUI.needBudget = Math.round(budget * needP / 100);
            topGUI.wantBudget = Math.round(budget * wantP / 100);
            topGUI.saveBudget = Math.round(budget * saveP / 100);

            createDB.insertTransaction("INCOME", budget, "2026-02-25", "BUDGET", "Initial Budget");
            Main.frame.setVisible(true);
            topGUI.initNetMoney();
            centerRightGUI.updateHistory();
            this.setVisible(false);
        }
    }

    public void textFieldAction(JSlider slider, JTextField textfield) {
        try {
            int value = Integer.parseInt(textfield.getText());
            if (value >= slider.getMinimum() && value <= slider.getMaximum()) {
                slider.setValue(value);
            } else {
                // Optional: Reset if out of range
                textfield.setText(String.valueOf(slider.getValue()));
            }
        } catch (NumberFormatException ex) {
            // Reset if invalid input
            textfield.setText(String.valueOf(slider.getValue()));
        }
    }

    public void setupSlider(JSlider slider, JTextField textField) {
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(10);

        textField.addActionListener(this);

        slider.addChangeListener(e -> textField.setText(String.valueOf(slider.getValue())));
    }
}

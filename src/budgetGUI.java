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

        ImageIcon background = new ImageIcon("src/img/whitebg2.jpg");
        JLabel imglabel = new JLabel(background);
        this.setContentPane(imglabel);

        heading = new JLabel("Enter your budget");
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        imglabel.add(heading);

        description = new JLabel(
                "<html>Please enter your budget for the month.<br> The amount entered will be split into sections (needs, <br> wants, save) based on your preference.</html>");
        description.setFont(new Font("Arial", Font.PLAIN, 18));
        imglabel.add(description);

        this.add(new JLabel("Budget ($): "));
        budgetTF = new JTextField(30);
        budgetTF.addActionListener(this);
        imglabel.add(budgetTF);

        // Need
        this.add(new JLabel("Need (%): "));
        needSlider = new JSlider(0, 100, 50);
        needTF = new JTextField(String.valueOf(needSlider.getValue()), 15);
        setupSlider(needSlider, needTF);
        System.out.println("Here");

        imglabel.add(needSlider);
        imglabel.add(needTF);

        // Want
        imglabel.add(new JLabel("Want (%): "));
        wantSlider = new JSlider(0, 100, 30);
        wantTF = new JTextField(String.valueOf(wantSlider.getValue()), 15);
        setupSlider(wantSlider, wantTF);

        imglabel.add(wantSlider);
        imglabel.add(wantTF);

        // Savings
        imglabel.add(new JLabel("Saving (%): "));
        saveSlider = new JSlider(0, 100, 20);
        saveTF = new JTextField(String.valueOf(saveSlider.getValue()), 15);
        setupSlider(saveSlider, saveTF);

        imglabel.add(saveSlider);
        imglabel.add(saveTF);

        submitButton = new JButton("Done");
        submitButton.addActionListener(this);
        imglabel.add(submitButton);

        this.setLayout(new java.awt.FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(450, 450);

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

            if (saveP + needP + wantP != 100) {
                JOptionPane.showMessageDialog(null,
                        "Error: Percentage does not add up to 100",
                        "System Message",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class introGUI extends JFrame implements ActionListener{
    JLabel introLabel;
    JLabel introText;
    JButton continueButton;
    JPasswordField password;

    public introGUI(){
        this.setLayout(new java.awt.FlowLayout());
        introLabel = new JLabel("Welcome to AAA Expense Tracker");
        this.add(introLabel);

        introText = new JLabel("This is an expense tracker where you can record your expenses, income, and add descriptions");
        this.add(introText);

        this.add(new JLabel("Enter your password: "));
        password = new JPasswordField(20);
        this.add(password);

        continueButton = new JButton("Continue");
        continueButton.addActionListener(this);
        this.add(continueButton);

        this.setVisible(true);
        
        this.setSize(300, 400);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createDB.setPassword(password.getText());
        setVisible(false);
    }
}

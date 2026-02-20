import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class introGUI extends JFrame implements ActionListener{
    JLabel introLabel1;
    JLabel introLabel2;
    JLabel introText;
    JButton continueButton;
    JPasswordField password;

    public introGUI(){
        this.setLayout(new java.awt.FlowLayout());
        introLabel1 = new JLabel("Welcome to...");
        introLabel1.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(introLabel1);

        introLabel2 = new JLabel("AAA Expense Tracker");
        introLabel2.setFont(new Font("Arial", Font.BOLD, 32));
        this.add(introLabel2);

        introText = new JLabel("<html>This is an expense tracker where<br> you can record your expenses, <br>income, and add descriptions</html>");
        introText.setFont( new Font("Arial", Font.PLAIN, 18));
        this.add(introText);

        this.add(new JLabel("Enter your password: "));
        password = new JPasswordField(20);
        this.add(password);

        continueButton = new JButton("Continue");
        continueButton.addActionListener(this);
        this.add(continueButton);

        this.setVisible(true);
        
        this.setSize(400, 300);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // createDB.setPassword("SQL.mtbt0511");
        // String str = String.valueOf(password.getPassword());
        String str = "SQL.mtbt0511";
        // System.out.println(str);
        createDB.setPassword(str);
        setVisible(false);
    }
}

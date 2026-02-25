import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteGUI extends JFrame implements ActionListener {
    JTextField componentID;
    JButton deleteButton;

    public deleteGUI() {
        this.setLayout(new java.awt.FlowLayout());
        componentID = new JTextField(20);

        this.add(new JLabel("Enter transaction ID: "));
        this.add(componentID);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        this.add(deleteButton);

        this.setSize(300, 200);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(componentID.getText());
        createDB.deleteTransaction(id);
        centerRightGUI.updateHistory();
        setVisible(false);
    }
}

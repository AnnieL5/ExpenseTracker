import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class topGUI extends JPanel implements ActionListener{
    private JButton addButton;
    static JLabel infoText;
    private addGUI addgui;

    public topGUI(){
        setBounds(0,0,400,400);
        setLayout(new FlowLayout());

        addButton = new JButton("Add");
        infoText = new JLabel();
        updateInfoText();

        addgui = new addGUI();

        addButton.addActionListener(this);

        this.add(addButton);
        this.add(infoText);

    }

    public static void updateInfoText(){
        infoText.setText("You lost money!");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        addgui.setVisible(true);
    }
}

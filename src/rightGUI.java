import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class rightGUI extends JPanel implements ActionListener {
    JButton resetDBbutton;
    JButton deleteDBbutton;

    deleteGUI deletegui;

    public rightGUI() {
        setLayout(new GridLayout(2,1));
        deletegui = new deleteGUI();

        resetDBbutton = new JButton("Reset Database");
        resetDBbutton.addActionListener(this);
        this.add(resetDBbutton);

        deleteDBbutton = new JButton("Delete transaction");
        deleteDBbutton.addActionListener(this);
        this.add(deleteDBbutton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetDBbutton) {
            createDB.resetDB();
            createDB.createTable();
            centerRightGUI.updateHistory();
            topGUI.resetInfoText();
        } else if (e.getSource() == deleteDBbutton){
            deletegui.setVisible(true);
        }
    }
}
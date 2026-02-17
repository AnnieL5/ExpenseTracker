import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class rightGUI extends JPanel implements ActionListener {
    JButton resetDBbutton;

    public rightGUI() {
        resetDBbutton = new JButton("Reset Database");
        resetDBbutton.addActionListener(this);
        this.add(resetDBbutton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetDBbutton) {
            createDB.resetDB();
            createDB.createTable();
            centerRightGUI.updateHistory();
        }
    }
}
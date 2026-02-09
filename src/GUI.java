import java.awt.*;
import javax.swing.*;

public class GUI extends JPanel{
    GridLayout layout;

    JLabel textLabel;
    JButton addButton;
    public GUI(){
        layout = new GridLayout();
        this.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();

        textLabel = new JLabel("Hello!");
        addButton = new JButton("add");

        addobjects(textLabel, addButton, null, gbc, ALLBITS, ABORT, WIDTH, HEIGHT);
    }

    public void addobjects(Component componente, Container yourcontainer, GridBagLayout layout, GridBagConstraints gbc, int gridx, int gridy, int igridwidth, int igridheigth){

        gbc.gridx = gridx;
        gbc.gridy = gridy;

        gbc.gridwidth = igridwidth;
        gbc.gridheight = igridheigth;

        layout.setConstraints(componente, gbc);
        yourcontainer.add(componente);
    }
}

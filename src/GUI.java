import java.awt.*;
import javax.swing.*;

public class GUI extends JPanel {
    GridBagLayout layout;

    JLabel textLabel;
    JButton addButton;
    GridBagConstraints gbc;

    public GUI() {
        layout = new GridBagLayout();
        this.setLayout(layout);

        gbc = new GridBagConstraints();

        textLabel = new JLabel("Hello!");
        addButton = new JButton("add");

        addobjects(textLabel, layout, gbc, 0, 0, 1, 1);
    }

    public void addobjects(Component componente, GridBagLayout layout, GridBagConstraints gbc, int gridx, int gridy,
            int igridwidth, int igridheigth) {

        gbc.gridx = gridx;
        gbc.gridy = gridy;

        gbc.gridwidth = igridwidth;
        gbc.gridheight = igridheigth;

        layout.setConstraints(componente, gbc);
        this.add(componente);
    }
}

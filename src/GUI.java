import java.awt.*;
import javax.swing.*;

public class GUI extends JPanel {
    GridBagLayout layout;

    JLabel textLabel;
    JLabel historyLabel;
    JButton addButton;
    GridBagConstraints gbc;

    public GUI() {
        layout = new GridBagLayout();
        this.setLayout(layout);

        gbc = new GridBagConstraints();

        textLabel = new JLabel("Hello!");
        addButton = new JButton("add");

        historyLabel = new JLabel("History:");

        addobjects(addButton, layout, gbc, 0, 0, 1, 1, true, false);
        addobjects(textLabel, layout, gbc, 1, 0, 1, 1, true, false);

        addobjects(historyLabel, layout, gbc, 4, 8, 2, 3,true, true);
    }

    public void addobjects(Component componente, GridBagLayout layout, GridBagConstraints gbc, int gridx, int gridy,
            int igridwidth, int igridheigth, boolean horizontal, boolean vertical) {

        gbc.gridx = gridx;
        gbc.gridy = gridy;

        gbc.gridwidth = igridwidth;
        gbc.gridheight = igridheigth;

        if(horizontal && vertical){
            gbc.fill = GridBagConstraints.BOTH;
        }else if(horizontal){
            gbc.fill = GridBagConstraints.HORIZONTAL;
        }else if(vertical){
            gbc.fill = GridBagConstraints.VERTICAL;
        }

        layout.setConstraints(componente, gbc);
        this.add(componente);

    }

    // public void addobjects(Component componente, GridBagLayout layout, GridBagConstraints gbc, int gridx, int gridy,
    //         int igridwidth, int igridheigth) {

    //     gbc.gridx = gridx;
    //     gbc.gridy = gridy;

    //     gbc.gridwidth = igridwidth;
    //     gbc.gridheight = igridheigth;

    //     layout.setConstraints(componente, gbc);
    //     this.add(componente);
    // }
}

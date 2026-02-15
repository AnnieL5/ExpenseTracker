import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static topGUI topgui;

    public static void main(String[] args) throws Exception {
        // Creating instance of JFrame
        JFrame frame = new JFrame();

        // // Creating instance of JButton
        // JButton button = new JButton(" Add");

        // x axis, y axis, width, height
        // button.setBounds(150, 200, 220, 50);

        // using no layout managers
        frame.setLayout(new BorderLayout());

        topgui = new topGUI();

        // adding button in JFrame
        frame.add(topgui, BorderLayout.PAGE_START);

        // 400 width and 500 height
        frame.setSize(500, 600);

        // frame.add(new GUI());
        // making the frame visible
        frame.setVisible(true);
    }
}

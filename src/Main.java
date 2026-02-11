import java.io.*;
import java.awt.*;
import javax.swing.*;


public class Main {
    public static topGUI topgui;
    public static centerGUI centergui;
    public static void main(String[] args) throws Exception {
        // Creating instance of JFrame
        JFrame frame = new JFrame();

        // using no layout managers
        frame.setLayout(new BorderLayout());

        topgui = new topGUI();
        centergui = new centerGUI();

        // adding button in JFrame
        frame.add(topgui, BorderLayout.PAGE_START);
        frame.add(centergui, BorderLayout.CENTER);

        // 400 width and 500 height
        frame.setSize(500, 600);


        /*GridBag layout */

        // JFrame frame = new JFrame();

        // frame.add(new GUI());
        // // making the frame visible
        // // Setting the frame size
        // frame.setSize(700, 500);  // Set an appropriate size for the frame

        // Setting the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}

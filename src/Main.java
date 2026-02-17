import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static topGUI topgui;
    public static centerGUI centergui;
    public static rightGUI rightgui;

    public static void main(String[] args) throws Exception {
        // Creating instance of JFrame
        JFrame frame = new JFrame();

        // using no layout managers
        frame.setLayout(new BorderLayout());

        topgui = new topGUI();
        centergui = new centerGUI();
        rightgui = new rightGUI();

        // adding button in JFrame
        frame.add(topgui, BorderLayout.PAGE_START);
        frame.add(centergui, BorderLayout.CENTER);
        frame.add(rightgui, BorderLayout.EAST);

        // 400 width and 500 height
        frame.setSize(700, 600);

        // createdb = new createDB();
        createDB.createDatabase();
        createDB.createTable();
        // createDB.insertTransaction(0, "2026-01-12", "NA");
        createDB.retrieveTransactions();

        /* GridBag layout */

        // JFrame frame = new JFrame();

        // frame.add(new GUI());
        // // making the frame visible
        // // Setting the frame size
        // frame.setSize(700, 500); // Set an appropriate size for the frame

        // Setting the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}

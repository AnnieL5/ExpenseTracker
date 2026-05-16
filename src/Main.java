import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Main {
    public static introGUI introgui;
    public static topGUI topgui;
    public static centerGUI centergui;
    public static rightGUI rightgui;
    public static budgetGUI budgetgui;

    public static JFrame frame;

    public static void main(String[] args) throws Exception {

        UIManager.put("Button.background", new Color(76, 175, 80));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.focus", new Color(76, 175, 80));
        UIManager.put("Button.select", new Color(56, 142, 60));

        UIManager.put("Button.font", new Font("SansSerif", Font.BOLD, 15));

        introgui = new introGUI();
        String pasw = createDB.getPassword();
        while (pasw.equals("")) {
            System.out.println("PSW: " + pasw);
            pasw = createDB.getPassword();
        }

        budgetgui = new budgetGUI();

        // Creating instance of JFrame
        frame = new JFrame();
        frame.setTitle("Budget Manager");

        ImageIcon background = new ImageIcon("src/img/greenbg2.jpg");
        JLabel imglabel = new JLabel(background);
        imglabel.setLayout(new BorderLayout(15, 15));

        frame.setContentPane(imglabel);

        topgui = new topGUI();
        centergui = new centerGUI();
        rightgui = new rightGUI();

        // adding button in JFrame
        frame.add(topgui, BorderLayout.PAGE_START);
        frame.add(centergui, BorderLayout.CENTER);
        frame.add(rightgui, BorderLayout.EAST);

        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null); // center screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(false);

        // 400 width and 500 height
        // frame.setSize(700, 600);

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

    }
}

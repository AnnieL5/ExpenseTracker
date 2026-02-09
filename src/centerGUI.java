import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class centerGUI extends JPanel{
    public static final String[] FILEPATH = {};
    private static BufferedImage[] bufferImage;
    public static Image[] images;

    private final int NUMPIC = FILEPATH.length;

    public centerGUI(){
        setVisible(true);
        setLayout(new GridLayout(1,2));
        
    }
}

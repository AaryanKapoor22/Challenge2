package src;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//A basic subclass of the JLabel with two constructors
public class label extends JLabel {

    //Label with text and position
    public label(String text, int x, int y) {
        super();
        this.setBounds(x, y, (int) (App.windowWidth*0.70), (int) (App.windowHeight*0.15));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font ("Arial", Font.BOLD, 24));
        this.setText(text);
        this.setOpaque(true);
        this.setBackground(new Color(108 ,180, 198));
    }

    //Label for images with position and size
    public label(ImageIcon image, int x, int y, int width, int height) {
        super();
        Image img = image.getImage();
        Image newImage = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImage);
        this.setIcon(newIcon);
        this.setBounds(x, y, width, height);
    }

}

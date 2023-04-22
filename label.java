import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class label extends JLabel {
    
    public label(String text, int x, int y) {
        super();
        this.setBounds(x, y, 1200, 200);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font ("Arial", Font.PLAIN, 20));
        this.setText(text);
        this.setOpaque(true);
        this.setBackground(Color.CYAN);
    }

    public label(Icon image, int x, int y, int width, int height) {
        super(image);
        this.setBounds(x, y, width, height);
    }

}

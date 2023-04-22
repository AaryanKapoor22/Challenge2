import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class button extends JButton {

    public button(String label, int x, int y) {
        super();
        this.setPreferredSize(new Dimension(400, 100));
        this.setBounds(x, y, 400, 100);
        this.setFont(new Font ("Arial", Font.PLAIN, 40));
        this.setText(label);
    } 

}

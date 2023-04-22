import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;

//Basic button subclass inherits properties from JButton superclass 
public class button extends JButton {

    //Creates a label which text and position can be defined
    public button(String label, int x, int y) {
        super();
        this.setPreferredSize(new Dimension(400, 100));
        this.setBounds(x, y, (int) (App.windowWidth*0.2), (int) (App.windowHeight*0.07));
        this.setFont(new Font ("Arial", Font.BOLD, 40));
        this.setText(label);
        this.setBackground(new Color(108 ,180, 198));
    }

    //Returns a string with the folder payth that the user selects from their file directory
    public static String selectFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        else {
            return "Error";
        }
    } 

}

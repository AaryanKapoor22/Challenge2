import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.*;
import java.io.File;

public class App extends JFrame {

    //static String path = "test";
    //static JLabel label = new JLabel("Please Press the Search Button to Select a Folder to Begin");
    public App() {
        super("Repo Creation App");
        this.setSize(2000, 1600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 

        this.add(new Panel());

        this.setVisible(true); 
    } 
    

    public static void main(String[] args) {
        new App();
    }
    /*public static void main(String[] args) {
        //Create JFrame with Exit on Close feature
        JFrame frame = new JFrame("Github Repo Creation App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000,1600);
        //Create JPanel and add to Frame 
        JPanel panel = new JPanel();
        //panel.setBackground(Color.RED);
        frame.add(panel); 

        //Create label to display information 
        //JLabel label = new JLabel("Please Press the Search Button to Select a Folder to Begin");
        panel.add(label);

        //Create button to select file path
        JButton selectFolderButton = new JButton("Search");
        selectFolderButton.setText("Search");
        selectFolderButton.setPreferredSize(new Dimension(100, 100));
        selectFolderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileSelect();
                label.setText(path);
            }
        });
        //JLabel label2 = new JLabel(selectedFile.getAbsolutePath());
        label.setText(path);
        panel.add(selectFolderButton);


        frame.setVisible(true);
    } 

    public static String fileSelect() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setPreferredSize(new Dimension(1600, 1200));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            //label.setText(selectedFile.getAbsolutePath());
            path = selectedFile.getAbsolutePath();
            label.setText(path);
            return selectedFile.getAbsolutePath();
        }
        else {
            return "Error";
        }
    }*/

}
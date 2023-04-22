import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;


public class App extends JFrame {

    //Gathers user screen resolution and sets window size to a 67% 
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public final static int windowWidth = (int) (screenSize.getWidth() - screenSize.getWidth()/3);
    public final static int windowHeight = (int) (screenSize.getHeight() - screenSize.getHeight()/3);

    public App() {
        //Creates a JFrame and defines some basic properties
        super("Repo Creation App");
        this.setSize(windowWidth, windowHeight);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setResizable(false);

        //Creates and Adds the JPanel to the JFrame
        this.add(new Panel());
        this.setVisible(true); 
    } 
    

    public static void main(String[] args) {
        //Creates a new instance of the repo cretaion application
        new App();
    }

}
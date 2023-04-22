import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class App extends JFrame {

    public App() {
        //Creates a JFrame and defines some basic properties
        super("Repo Creation App");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        this.setSize((int)width, (int)height);
        System.out.print((int)width + "height" + (int)height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 

        //Creates and Adds the JPanel to the JFrame
        this.add(new Panel());
        this.setVisible(true); 
    } 
    

    public static void main(String[] args) {
        //Creates a new instance of the repo cretaion application
        new App();
    }

}
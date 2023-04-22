import javax.swing.*;

public class App extends JFrame {

    public App() {
        //Creates a JFrame and defines some basic properties
        super("Repo Creation App");
        this.setSize(2000, 1600);
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
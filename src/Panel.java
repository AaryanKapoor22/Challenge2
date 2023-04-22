package src;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel extends JPanel {

    //Instance variables 
    private button searchButton;
    private label gitHubImage;
    private label instructionsLabel; 
    private JTextField textbox;
    private JButton enterButton; 
    private String folderPath;

    public Panel() {
        //Creates and defines basic JPanel properties 
        super();
        this.setLayout(null);
        this.setSize(App.windowWidth, App.windowHeight);
        this.setBackground(new Color(248 , 240, 227));

        //Creates the directory seacrh button 
        this.searchButton = new button("Directory Search", (App.windowWidth/20), (int) (App.windowHeight*0.80));
        //If the button is pressed search the file director and set the textbox text to the folder path
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                folderPath = button.selectFile(); 
                //If folder path not specified return error message
                if(folderPath.equals("Error")) {
                    instructionsLabel.setText("Please try again.");
                } 
                //Otherwise display selected folder path and give next instruction
                else {
                    textbox.setText(folderPath);
                    instructionsLabel.setText("Create Repo Step");
                }
            }
        });
        
        //GitHub Logo Image 
        this.gitHubImage = new label(new ImageIcon("GitHub-Logo.png"), (int) (App.windowWidth*0.25), (int) (App.windowHeight*0.05), (int) (App.windowWidth/2), (int) (App.windowHeight/2));

        //Instructions label
        this.instructionsLabel = new label("Select 'Search Directory' to specify the Repo Folder Path", (int) (App.windowWidth*0.15), (int) (App.windowHeight*0.60)); 

        //Textbox for user input 
        this.textbox = new JTextField("Enter Input Here!"); 
        this.textbox.setBounds((int) (App.windowWidth*0.3), (int) (App.windowHeight*0.80), (int) (App.windowWidth*0.4), (int) (App.windowHeight*0.07));
        this.textbox.setHorizontalAlignment(SwingConstants.CENTER);
        this.textbox.setFont(new Font ("Arial", Font.BOLD, 24));
        this.textbox.setBackground(new Color(108 ,180, 198));

        //Enter button for basic control flow 
        this.enterButton = new button("Enter", (int) (App.windowWidth*0.75), (int) (App.windowHeight*0.80));

        //Adds components to the JPanel
        this.add(searchButton);
        this.add(gitHubImage);
        this.add(instructionsLabel); 
        this.add(textbox);
        this.add(enterButton);
    }
}
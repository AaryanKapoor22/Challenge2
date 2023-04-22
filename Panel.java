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

    public Panel() {
        //Creates and defines basic JPanel properties 
        super();
        this.setLayout(null);
        this.setSize(2000, 1600);
        this.setBackground(new Color(248 , 240, 227));

        //Creates the directory seacrh button 
        this.searchButton = new button("Directory Search", 100, 1200);
        //If the button is pressed search the file director and set the textbox text to the folder path
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textbox.setText(button.selectFile());
            }
        });
        
        //GitHub Logo Image 
        this.gitHubImage = new label(new ImageIcon("GitHub-Logo.png"), 360, 100, 1280, 720);

        //Instructions label
        this.instructionsLabel = new label("Instructions Here", 300,900); 

        //Textbox for user input 
        this.textbox = new JTextField("Enter Input Here!"); 
        this.textbox.setBounds(600, 1200, 800, 100);
        this.textbox.setHorizontalAlignment(SwingConstants.CENTER);
        this.textbox.setFont(new Font ("Arial", Font.BOLD, 24));
        this.textbox.setBackground(new Color(108 ,180, 198));

        //Enter button for basic control flow 
        this.enterButton = new button("Enter", 1500, 1200);

        //Adds components to the JPanel
        this.add(searchButton);
        this.add(gitHubImage);
        this.add(instructionsLabel); 
        this.add(textbox);
        this.add(enterButton);
    }
}
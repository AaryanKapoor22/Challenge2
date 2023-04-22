import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel extends JPanel {

    private button searchButton;
    private label gitHubImage;
    private label instructionsLabel; 
    private JTextField textbox;
    private JButton enterButton;
    //private LayoutManager layout;

    public Panel() {
        super();
        this.setLayout(null);
        this.setSize(2000, 1600);
        this.setBackground(Color.WHITE); 

        this.searchButton = new button("Directory Search", 100, 1200);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchButton.setText("It worked");
            }
        });

        this.gitHubImage = new label(new ImageIcon("GitHub-Logo.png"), 360, 100, 1280, 720);

        this.instructionsLabel = new label("Instructions Here", 400,900); 

        this.textbox = new JTextField("Enter Input Here!"); 
        this.textbox.setBounds(600, 1200, 800, 100);
        this.textbox.setHorizontalAlignment(SwingConstants.CENTER);
        this.textbox.setFont(new Font ("Arial", Font.PLAIN, 20));

        this.enterButton = new button("Enter", 1500, 1200);

        this.add(searchButton);
        this.add(gitHubImage);
        this.add(instructionsLabel); 
        this.add(textbox);
        this.add(enterButton);
    }
}
package src;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import git.tools.client.GitSubprocessClient;
import github.tools.*;
import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
import github.tools.responseObjects.*;

public class Panel extends JPanel {

    //Instance variables 
    private button searchButton;
    private label gitHubImage;
    private label instructionsLabel; 
    private JTextField textbox;
    private JButton enterButton; 
    private String folderPath; 
    private boolean collectPath;
    private String username; 
    private boolean collectUsername; 
    private boolean collectRepoName;
    private boolean collectRepoVisibility;
    private boolean collectDescription;
    private String token;
    private String repoName;
    private String visibility;
    private String description;
    private String isPublic;
    private boolean collectToken; 
    private boolean allowCreateRepo;

    private RequestParams requestParams;
    private GitHubApiClient gitHubApiClient;

    public Panel() {
        //Creates and defines basic JPanel properties 
        super();
        this.setLayout(null);
        this.setSize(App.windowWidth, App.windowHeight);
        this.setBackground(new Color(248 , 240, 227)); 

        collectPath = true;
        collectUsername = false;
        collectToken = false; 
        allowCreateRepo = false;
        collectRepoName=false;
        collectRepoVisibility = false;

        //Creates the directory seacrh button 
        this.searchButton = new button("Directory Search", (App.windowWidth/20), (int) (App.windowHeight*0.80));
        this.searchButton.setFont(new Font ( searchButton.getFont().toString(), Font.BOLD, 20));
        searchButton.getFont();
        //If the button is pressed search the file director and set the textbox text to the folder path
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(collectPath == true) {
                    folderPath = button.selectFile(); 
                    //If folder path not specified return error message
                    if(folderPath.equals("Error")) {
                        instructionsLabel.setText("Please try again.");
                    } 
                    //Otherwise display selected folder path and give next instruction
                    else {
                        instructionsLabel.setText("Please enter GitHub Username and Select 'Enter'");
                        collectPath = false;
                        collectUsername = true;
                    // Set Directory background color to grey and disable it
                        searchButton.setBackground(Color.GRAY);
                        searchButton.setEnabled(false);
                    }
                }
            }
        });
        
        //GitHub Logo Image 
        this.gitHubImage = new label(new ImageIcon(getClass().getClassLoader().getResource("GitHub-Logo.png")), (int) (App.windowWidth*0.25), (int) (App.windowHeight*0.05), (int) (App.windowWidth/2), (int) (App.windowHeight/2));

        //Instructions label
        this.instructionsLabel = new label("Input the Repo Folder Path and Select 'Enter' or Select 'Search Directory' to browse for the Repo Folder Path", (int) (App.windowWidth*0.15), (int) (App.windowHeight*0.60)); 
        instructionsLabel.setFont(new Font ( instructionsLabel.getFont().toString(), Font.BOLD, 12));
        //Textbox for user input 
        this.textbox = new JTextField("Enter Input Here!");
        this.textbox.setBounds((int) (App.windowWidth*0.3), (int) (App.windowHeight*0.80), (int) (App.windowWidth*0.4), (int) (App.windowHeight*0.07));
        this.textbox.setHorizontalAlignment(SwingConstants.CENTER);
        this.textbox.setFont(new Font ("Arial", Font.BOLD, 24));
        this.textbox.setBackground(new Color(108 ,180, 198));

        //Enter button for basic control flow 
        this.enterButton = new button("Enter", (int) (App.windowWidth*0.75), (int) (App.windowHeight*0.80));
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Collects Folder Path
                if(collectPath == true) {
                    folderPath = textbox.getText();
                    collectPath = false;
                    collectUsername = true;
                    instructionsLabel.setText("Folder Path: " + folderPath + ". Please enter GitHub Username and Select 'Enter'");      
                }
                //Collects GitHub Username
                else if(collectUsername == true) {
                    username = textbox.getText();
                    collectUsername = false;
                    collectToken = true; 
                    instructionsLabel.setText("Username: " + username + ". Please enter GitHub Token and Select 'Enter;");
                }
                //Collects GitHub Password
                else if(collectToken == true) {
                    token = textbox.getText();
                    collectToken = false;
                    collectRepoVisibility = true;
                    //instructionsLabel.setText("Please enter the Repo Name: ");
                    instructionsLabel.setText("Do you want your repo to be Public. Please type (true or false) for this!");
                }
                else if(collectRepoVisibility == true) {
                    visibility = textbox.getText();
                    System.out.println("visibility:"+visibility);
                    collectRepoVisibility =false;
                    collectDescription = true;
                    //instructionsLabel.setText("Do you want your repo to be Public. Please type (true or false) for this!");
                    instructionsLabel.setText("Please enter a description of your repo!");

                }
                else if(collectDescription == true) {
                    description = textbox.getText();
                    System.out.println("description"+description);
                    collectRepoName = true;
                    collectDescription = false;
                    collectRepoVisibility =false;
                    //instructionsLabel.setText("Please enter a description of your repo!");
                    instructionsLabel.setText("Please enter the Repo Name: ");
                }
                else if(collectRepoName == true) {
                    repoName = textbox.getText();
                    System.out.println("repo name"+repoName);
                    collectRepoName = false; 
                    allowCreateRepo = true;
                    instructionsLabel.setText("Thank you. Please Select 'Create Repo' to Create Repo now...");
                    textbox.setBackground(Color.GRAY);
                    textbox.setEnabled(false);
                    enterButton.setText("Create Repo");
                }
                //Initiates Repo Creation
                else if(allowCreateRepo = true) {       
                    instructionsLabel.setText("Repo is now Being Created!");
                    GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(folderPath);
                    String gitInit = gitSubprocessClient.gitInit();
                    File gitIgnore = new File(folderPath,".gitignore");
                    PrintWriter gitIgnoreWrite = null;
                    try{
                        gitIgnore.createNewFile();
                        gitIgnoreWrite = new PrintWriter(gitIgnore);

                        gitIgnoreWrite.println(".classpath");
                        gitIgnoreWrite.println("*.class");
                        gitIgnoreWrite.println("jdk/");
                        gitIgnoreWrite.println(".vsc/");
                        gitIgnoreWrite.println(".idea/");
                        gitIgnoreWrite.println("*.iml");
                        gitIgnoreWrite.println(".DS_Store");
                        gitIgnoreWrite.println("out/");
                        gitIgnoreWrite.flush();

                    } catch(IOException e1){
                        System.out.println("Error while writing to file.");
                    } finally {
                        gitIgnoreWrite.close();
                    }
                    File README = new File(folderPath,"README.md");
                    PrintWriter readmePrintWriter = null;
                    try{
                        README.createNewFile();
                        readmePrintWriter = new PrintWriter(README);
                        readmePrintWriter.println("## " + repoName);
                        readmePrintWriter.flush();

                    } catch(IOException e1){
                        System.out.println("Error while writing to file.");
                    } finally {
                        readmePrintWriter.close();
                    }
                    String addCommand = gitSubprocessClient.gitAddAll();
                    String commitMessage = "initial commit";
                    String commitmsg = gitSubprocessClient.gitCommit(commitMessage);

                    gitHubApiClient = new GitHubApiClient(username,token);
                    requestParams = new RequestParams();
                    requestParams.addParam("name", repoName);
                    requestParams.addParam("description", description);
                    if(visibility.equalsIgnoreCase("true")){
                        requestParams.addParam("private", false);
                    }else if(visibility.equalsIgnoreCase("false")){
                        requestParams.addParam("private", true);
                    }else{
                        requestParams.addParam("private", false);
                    }
                    CreateRepoResponse createRepoResponse = gitHubApiClient.createRepo(requestParams);

                    GetRepoInfoResponse repoDesc = gitHubApiClient.getRepoInfo(username, repoName);

                    String url = repoDesc.getUrl();
                    String remoteAdd = gitSubprocessClient.gitRemoteAdd("origin", url + ".git");

                    String originPush = gitSubprocessClient.gitPush("master");
                    System.out.println(originPush);

                    instructionsLabel.setText("GitHub Repo has been Created! URL: " + url);
                    enterButton.setEnabled(false);
                    enterButton.setBackground(Color.GRAY);

                }
                else {
                    System.out.println("Error!");
                }
                textbox.setText("Enter Input Here!");
            }
        });  

        //Adds components to the JPanel
        this.add(searchButton);
        this.add(gitHubImage);
        this.add(instructionsLabel); 
        this.add(textbox);
        this.add(enterButton);
    }
}
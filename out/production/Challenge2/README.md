# BetterThanGitDesktop

## Description
BetterThanGitDesktop is a GUI application that simplifies the process of converting an existing project on your computer to a Git repository and pushing it to GitHub. The application performs the following tasks:
- Converts a project on the user's computer to a Git repository
- Creates an initial commit in the Git repository
- Creates a GitHub repository that mirrors the Git repository on the user's computer

The application is a prototype, and error handling is decent but some places might not have it implemented, with only a simple error message displayed if the steps are not carried out correctly. The GUI design is basic and includes the Github Logo, as well as a disclaimer stating that the application is a prototype and not yet meant for commercial use.

## Requirements
- Java 8 or later version
- External libraries used: 
    - GitHubApiClient - available at https://github.com/CSC109/GitHubApiClient
    - GitSubprocessClient - available at https://github.com/CSC109/GitSubprocessClient

## Installation and Usage
1. Download and install Java 8 or later version.
2. Clone the repo by setting this as your clone link https://github.com/MineGamer69/Challenge2.git
3. Download the GitHubApiClient and GitSubprocessClient and add them to the project's classpath (CTRL + SHIFT + P) and search for Configure Classpath.
4. Run the App.java file
5. Select the project on your computer that you want to convert to a Git repository.
7. Click the "Create GitHub Repo" button to create the GitHub repository and push the initial commit.
8. Copy the URL to your newly created GitHub repository.

## Note: 
This application requires a GitHub account and access token to authenticate and authorize API requests. Please ensure that you have set up a GitHub account and generated an access token before using the application.

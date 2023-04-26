# BetterThanGitDesktop

## Description
BetterThanGitDesktop is a GUI application that simplifies the process of converting an existing project on your computer to a Git repository and pushing it to GitHub. The application performs the following tasks:

- Converts a project on the user's computer to a Git repository
- Adds a Git Ignore file to the project to exclude common files/patterns
- Adds a README file with the name of the project as a markdown header
- Creates an initial commit in the Git repository
- Creates a GitHub repository that mirrors the Git repository on the user's computer
- Allows the user to set the repository's description and visibility (private or public)
- Sets the Git repository's remote to the GitHub repository as "origin"
- Pushes the initial commit to the GitHub repository
- Provides the user with a URL to their newly created GitHub repository

The application is a prototype, and error handling is decent but some places might not have it implemented, with only a simple error message displayed if the steps are not carried out correctly. The GUI design is basic and includes the Github Logo.

## Requirements
- Java 8 or later version
- External libraries used: 
    - GitHubApiClient - available at https://github.com/CSC109/GitHubApiClient
    - GitSubprocessClient - available at https://github.com/CSC109/GitSubprocessClient

## Installation and Usage
1. Download and install Java 8 or later version.
2. Go to the releases panel and download the Latest release
3. Double click the BetterThanGitDesktop.jar file 
4. Select the project on your computer that you want to convert to a Git repository.
5. Fill in the required options and settings and follow the textbox!
6. Click the "Create GitHub Repo" button to create the GitHub repository.
7. Copy the URL to your newly created GitHub repository.

## Note: 
This application requires a GitHub account and access token to authenticate and authorize API requests. Please ensure that you have set up a GitHub account and generated an access token before using the application.

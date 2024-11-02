## Project description
This program determines the popularity of words in class names across Java-based projects hosted on GitHub.
Using Kotlin and the GitHub API, it retrieves data on class names from a wide variety of repositories, analyzes word frequencies, and presents the most commonly used words.

**Key features:**
* Kotlin Implementation: Leverages Kotlin’s robust capabilities for data processing.
* GitHub API Integration: Connects to GitHub to retrieve class names from Java projects.
* Customizable Analysis: Allows for flexible word analysis and filtering criteria, making it adaptable to different data sets.

## Requirements and setup
To run this project, you need to provide a GitHub personal access token.
Set this token as an environment variable named `GITHUB_TOKEN`.

1. **Generate a GitHub Personal Access Token:**
* Go to [GitHub's settings](https://github.com/settings/tokens).
* Generate a new token with `repo` and `public_repo` scopes. (or other appropriate permissions for the data you intend to access).

2. **Set the Environment Variable:**
* On macOS/Linux: `export GITHUB_TOKEN=your_token_here`
* On Windows (Command Prompt):  `set GITHUB_TOKEN=your_token_here`
  This token is necessary for authenticating API requests to GitHub.

## Accessing the Most Popular Classes
To retrieve the list of the most popular class names, make a request to the following API endpoint after starting the application:
* [Most Popular Classes API](http://localhost:8080/popular-classnames/process)
  This endpoint processes and returns a ranked list of popular class names based on the analysis.

# Task Tracker CLI

Repository created to present the solution to the project idea of [Task-Tracker](https://roadmap.sh/projects/task-tracker).

This project focuses in creating a CLI interface that tracks any of your created tasks. To do this the CLI presents a lot of helpful commands to realize some activites as: add new tasks, remove any task, update data from a task.

This project was created using Java cause the author was more focused in doing any program than finding the "best" language program to the solution.

Right now this project is attending 100% of the challenge presented in the site. But with this implementation it could be possible to create a undo command by using the backup file that it is created.

Big thanks to Le Phuoc Loc, the owner of the repository: [task_tracker_cli](https://github.com/lephuocloc1729/task_tracker_cli/tree/main), because I've studied some parts of the code to learn new ways to program in Java and also manipulate the strings in the project.

## Pre-Requisites
 - Java 23
 - Git Bash
 - Gradle 8.10

## Execution

### For Windows

 1. Clone repository;
 ```bash
  git clone https://github.com/Lucas-Sandro-Rotermel-Franco/TaskTrackerCLI.git
  cd F:\Repositories\TaskTrackerCLI
 ```
 2. Compile the code:
  ```bash
    ./gradlew jar
  ```

 3. Access the Windows Environment Variables; 
  
    3.1 Add to the PATH variable the directory where the repository was cloned. Example:
      ![Path environment](https://github.com/Lucas-Sandro-Rotermel-Franco/TaskTrackerCLI/blob/master/images/PATH.png)

  4. After this open the CMD and run the command:
   ``` 
     task-cli --help
  ```

This will start the task-cli showing the allowed commands!

### For Linux
1. Clone repository;
 ```bash
  git clone https://github.com/Lucas-Sandro-Rotermel-Franco/TaskTrackerCLI.git
  cd F:\Repositories\TaskTrackerCLI
 ```
2. Compile the code:
  ```bash
    ./gradlew jar
  ```
3. Execute the application:
  ```bash
    java -jar F:\Repositories\TaskTrackerCLI\build\libs\TaskTracker.jar <command> [arguments]
  ```

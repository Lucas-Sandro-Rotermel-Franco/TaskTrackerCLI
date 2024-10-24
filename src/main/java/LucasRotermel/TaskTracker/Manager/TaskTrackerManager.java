package LucasRotermel.TaskTracker.Manager;

import LucasRotermel.TaskTracker.Commands.*;

public class TaskTrackerManager {
    public void init(String[] args) {

        switch (args[0]) {
            case "add"             : executeCommand(new Add           ()); break;
            case "delete"          : executeCommand(new Delete        ()); break;
            case "list"            : executeCommand(new List          ()); break;
            case "mark-done"       : executeCommand(new MarkDone      ()); break;
            case "mark-in-progress": executeCommand(new MarkInProgress()); break;
            case "update"          : executeCommand(new Update        ()); break;
        }
    }

    private void executeCommand(Command command) {
        command.execute();
    }
}

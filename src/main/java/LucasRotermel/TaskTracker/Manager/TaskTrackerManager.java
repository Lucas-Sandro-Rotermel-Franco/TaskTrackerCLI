package LucasRotermel.TaskTracker.Manager;

import LucasRotermel.TaskTracker.Commands.Add;
import LucasRotermel.TaskTracker.Commands.Command;

public class TaskTrackerManager {
    public void init(String[] args) {

        switch (args[0]) {
            case "add": executeCommand(new Add()); break;
        }
    }

    private void executeCommand(Command command) {
        command.execute();
    }
}

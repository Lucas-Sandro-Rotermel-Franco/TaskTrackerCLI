package LucasRotermel.TaskTracker.Client;

import LucasRotermel.TaskTracker.Exceptions.ArgumentQuantityException;
import LucasRotermel.TaskTracker.Manager.TaskTrackerManager;

public class TaskTrackerMain {
    public static void main(String[] args) throws ArgumentQuantityException{
        TaskTrackerManager manager = new TaskTrackerManager();
        try {
            if (args.length == 0)
                throw new ArgumentQuantityException("It's necessary to pass at least one argument. Please refer to --help if necessary");

            manager.init(args);
        } catch (ArgumentQuantityException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

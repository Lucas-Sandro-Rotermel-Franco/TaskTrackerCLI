package LucasRotermel.TaskTracker.Utils;

import LucasRotermel.TaskTracker.Exceptions.ArgumentTypeException;
import LucasRotermel.TaskTracker.Exceptions.IdentifierInexistentException;
import LucasRotermel.TaskTracker.Manager.Task;

import java.util.List;

public class IntValidations {

    public static int validateIndexExists(int idx, List<Task> tasks) {
        for (Task task : tasks) {
            if (task.getId() == idx)
                return tasks.indexOf(task);
        }

        throw new IdentifierInexistentException();
    }

    public static int isNumber(String number) {
        int idx;

        try {
            idx = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new ArgumentTypeException();
        }

        return idx;
    }
}

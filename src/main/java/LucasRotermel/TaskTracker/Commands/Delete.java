package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.ArgumentQuantityException;
import LucasRotermel.TaskTracker.Exceptions.ArgumentTypeException;
import LucasRotermel.TaskTracker.Exceptions.IdentifierInexistentException;
import LucasRotermel.TaskTracker.Exceptions.IncorrectExecuteException;
import LucasRotermel.TaskTracker.Manager.Task;

import java.util.List;

public class Delete extends Command{
    @Override
    public List<Task> execute(List<Task> tasks, String[] args) {
        if (args.length > 2)
            throw new ArgumentQuantityException(args.length - 1, "delete", "1");

        int idx;

        try {
            idx = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new ArgumentTypeException();
        }

        boolean idxExists = false;

        for (Task task : tasks) {
            if (task.getId() == idx) {
                idxExists = true;
                break;
            }
        }

        if (!idxExists)
            throw new IdentifierInexistentException();

        idx = idx - 1;

        tasks.remove(idx);

        return tasks;
    }

    @Override
    public void execute() {
        throw new IncorrectExecuteException();
    }
}

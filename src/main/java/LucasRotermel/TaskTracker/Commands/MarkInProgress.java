package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.ArgumentQuantityException;
import LucasRotermel.TaskTracker.Exceptions.ArgumentTypeException;
import LucasRotermel.TaskTracker.Exceptions.IdentifierInexistentException;
import LucasRotermel.TaskTracker.Exceptions.IncorrectExecuteException;
import LucasRotermel.TaskTracker.Manager.Task;
import LucasRotermel.TaskTracker.Utils.IntValidations;

import java.util.List;

public class MarkInProgress extends Mark{
    public MarkInProgress() {
        super("in-progress");
    }

    @Override
    public List<Task> execute(List<Task> tasks, String[] args) {
        if (args.length != 2)
            throw new ArgumentQuantityException(args.length - 1, "mark-in-progress", "1");

        int idx = IntValidations.isNumber(args[1]);

        return super.changeStatus(tasks, idx);
    }

    @Override
    public void execute() {
        throw new IncorrectExecuteException();
    }
}

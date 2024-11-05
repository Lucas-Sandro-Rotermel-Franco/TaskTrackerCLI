package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.ArgumentQuantityException;
import LucasRotermel.TaskTracker.Exceptions.IdentifierInexistentException;
import LucasRotermel.TaskTracker.Exceptions.IncorrectExecuteException;
import LucasRotermel.TaskTracker.Manager.Task;
import LucasRotermel.TaskTracker.Utils.IntValidations;

import java.util.List;

public class MarkDone extends Mark{

    public MarkDone() {
        super("done");
    }

    @Override
    public List<Task> execute(List<Task> tasks, String[] args) {
        if (args.length != 2)
            throw new ArgumentQuantityException(args.length - 1, "mark-done", "1");

        int idx = IntValidations.isNumber(args[1]);

        return super.changeStatus(tasks, idx);
    }

    @Override
    public void execute() {
        throw new IncorrectExecuteException();
    }
}

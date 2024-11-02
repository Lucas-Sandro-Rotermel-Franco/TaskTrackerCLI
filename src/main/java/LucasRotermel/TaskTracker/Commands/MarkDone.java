package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.ArgumentQuantityException;
import LucasRotermel.TaskTracker.Exceptions.IncorrectExecuteException;
import LucasRotermel.TaskTracker.Manager.Task;

import java.util.List;

public class MarkDone extends Mark{

    public MarkDone() {
        super("done");
    }

    @Override
    public List<Task> execute(List<Task> tasks, String[] args) {
        if (args.length <= 1 || args.length > 2)
            throw new ArgumentQuantityException(args.length - 1, "mark-done", "1");

        return super.changeStatus(tasks, Integer.parseInt(args[1]));
    }

    @Override
    public void execute() {
        throw new IncorrectExecuteException();
    }
}

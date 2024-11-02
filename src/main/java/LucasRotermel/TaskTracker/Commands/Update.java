package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.IncorrectExecuteException;
import LucasRotermel.TaskTracker.Manager.Task;

import java.util.List;

public class Update extends Command{
    @Override
    public List<Task> execute(List<Task> tasks, String[] args) {

        return tasks;
    }

    @Override
    public void execute() {
        throw new IncorrectExecuteException();
    }
}

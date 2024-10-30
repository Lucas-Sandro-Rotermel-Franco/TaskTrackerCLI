package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.IncorrectExecuteException;
import LucasRotermel.TaskTracker.Manager.Task;

import java.util.List;

public class Delete extends Command{
    @Override
    public List<Task> execute(List<Task> file, String[] args) {
        System.out.println("Hello Delete");
        return file;
    }

    @Override
    public void execute() {
        throw new IncorrectExecuteException();
    }
}

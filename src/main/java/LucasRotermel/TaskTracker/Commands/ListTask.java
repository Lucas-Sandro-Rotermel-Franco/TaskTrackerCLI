package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.IncorrectExecuteException;
import LucasRotermel.TaskTracker.Manager.Task;

import java.util.List;

public class ListTask extends Command{
    @Override
    public List<Task> execute(List<Task> file, String[] args) {
        System.out.println("Hello list");
        return file;
    }
    //Needs to list all tasks
    // And also only the ones that are: done, not done, in progress

    @Override
    public void execute() {
        throw new IncorrectExecuteException();
    }
}

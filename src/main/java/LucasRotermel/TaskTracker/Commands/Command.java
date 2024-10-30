package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Manager.Task;

import java.util.List;

public abstract class Command {

    public abstract void execute();

    public abstract List<Task> execute(List<Task> file, String[] args);
}

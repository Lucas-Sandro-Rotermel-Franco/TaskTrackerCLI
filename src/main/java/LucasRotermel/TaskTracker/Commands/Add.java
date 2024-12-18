package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.ArgumentQuantityException;
import LucasRotermel.TaskTracker.Exceptions.IncorrectExecuteException;
import LucasRotermel.TaskTracker.Manager.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Add extends Command {
    private int id;

    public Add(int id) {
        super();
        this.id = id;
    }

    @Override
    public List<Task> execute(List<Task> tasks, String[] args) {
        if (args.length != 2)
            throw new ArgumentQuantityException(args.length - 1, "Add", "1" );

        Task task = new Task();
        task.setId(this.id + 1);
        task.setDescription(args[1]);
        task.setStatus("todo");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        task.setDtCreated(dtf.format(LocalDateTime.now()));
        task.setDtUpdated(dtf.format(LocalDateTime.now()));

        tasks.add(task);

        return tasks;
    }

    @Override
    public void execute() {
        throw new IncorrectExecuteException();
    }
}

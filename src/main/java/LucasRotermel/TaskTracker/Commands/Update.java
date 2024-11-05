package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.ArgumentQuantityException;
import LucasRotermel.TaskTracker.Exceptions.IncorrectExecuteException;
import LucasRotermel.TaskTracker.Manager.Task;
import LucasRotermel.TaskTracker.Utils.IntValidations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Update extends Command{
    @Override
    public List<Task> execute(List<Task> tasks, String[] args) {
        if (args.length != 3)
            throw new ArgumentQuantityException(args.length - 1, "Update", "2" );

        int id = IntValidations.isNumber(args[1]);

        id = IntValidations.validateIndexExists(id, tasks);

        tasks.get(id).setDescription(args[2]);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        tasks.get(id).setDtUpdated(dtf.format(LocalDateTime.now()));

        return tasks;
    }

    @Override
    public void execute() {
        throw new IncorrectExecuteException();
    }
}

package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.InexistentIDException;
import LucasRotermel.TaskTracker.Exceptions.StatusFlowException;
import LucasRotermel.TaskTracker.Manager.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Mark extends Command{
    private String status;

    public Mark(String status) {
        this.status = status;
    }

    protected List<Task> changeStatus(List<Task> tasks, int id) {
        int index = obtainIndex(tasks, id);

        if (index == -1)
            throw new InexistentIDException();

        if (status.equals("done") && !tasks.get(index).getStatus().equals("in-progress"))
            throw new StatusFlowException();

        if (status.equals("in-progress") && !tasks.get(index).getStatus().equals("todo"))
            throw new StatusFlowException();

        tasks.get(index).setStatus(status);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        tasks.get(index).setDtUpdated(dtf.format(LocalDateTime.now()));

        return tasks;
    }

    private int obtainIndex(List<Task> tasks, int id) {
        for (Task task : tasks) {
            if (task.getId() == id)
                return tasks.indexOf(task);
        }

        return -1;
    }
}

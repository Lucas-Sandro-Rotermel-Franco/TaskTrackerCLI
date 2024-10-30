package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Manager.Task;

import java.util.List;

public class Help extends Command {

    @Override
    public List<Task> execute(List<Task> file, String[] args) {
        this.execute();
        return file;
    }

    @Override
    public void execute() {
        System.out.println("usage: task-cli <command> [<args>]\n\n");
        System.out.println("These are the commands necessary to use the system:\n");
        System.out.println("add [<task name>]                              Add new task");
        System.out.println("delete [<task sequence number>]                Delete existing task");
        System.out.println("update [<task sequence number>] [<task name>]  Update existing task name");
        System.out.println("mark-in-progress [<task sequence number>]      Update task to in-progress status");
        System.out.println("mark-done [<task sequence number>]             Update task to done status");
        System.out.println("list [<Optional status>]                       Show all tasks or filtered by status");
    }
}

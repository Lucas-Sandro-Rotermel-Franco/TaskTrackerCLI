package LucasRotermel.TaskTracker.Commands;

public class List extends Command{
    @Override
    public void execute() {
        System.out.println("Hello list");
    }
    //Needs to list all tasks
    // And also only the ones that are: done, not done, in progress
}

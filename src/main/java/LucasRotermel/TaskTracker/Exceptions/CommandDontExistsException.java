package LucasRotermel.TaskTracker.Exceptions;

public class CommandDontExistsException extends RuntimeException {
    public CommandDontExistsException() {
        super("The command doesn't exist! Please validate --help to know all existing commands!");
    }
}

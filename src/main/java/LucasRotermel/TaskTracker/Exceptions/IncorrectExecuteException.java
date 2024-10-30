package LucasRotermel.TaskTracker.Exceptions;

public class IncorrectExecuteException extends RuntimeException {
    public IncorrectExecuteException() {
        super("Incorrect execute implementation used. Please refer to --help");
    }
}

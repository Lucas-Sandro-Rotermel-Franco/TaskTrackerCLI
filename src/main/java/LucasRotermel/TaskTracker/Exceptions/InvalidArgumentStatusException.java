package LucasRotermel.TaskTracker.Exceptions;

public class InvalidArgumentStatusException extends RuntimeException {
    public InvalidArgumentStatusException() {
        super("Status argument doesn't exist, please refer to --help command to see valid status.");
    }
}

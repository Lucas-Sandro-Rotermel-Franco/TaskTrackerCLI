package LucasRotermel.TaskTracker.Exceptions;

public class ArgumentTypeException extends RuntimeException {
    public ArgumentTypeException() {
        super("The type of the argument is incorrect, please validate our help guide.");
    }
}

package LucasRotermel.TaskTracker.Exceptions;

public class ArgumentQuantityException extends RuntimeException {
    public ArgumentQuantityException(String message) {
        super(message);
    }

    public ArgumentQuantityException(int obtained, String command) {
        new ArgumentQuantityException("Expected arguments to command " + command);
    }
}

package LucasRotermel.TaskTracker.Exceptions;

public class ArgumentQuantityException extends RuntimeException {
    public ArgumentQuantityException(String message) {
        super(message);
    }

    public ArgumentQuantityException(int obtained, String command, String expected) {
        super("Expected quantity of arguments to command " + command + ": " + expected
                                      + "\nObtained arguments quantity: " + obtained);
    }
}

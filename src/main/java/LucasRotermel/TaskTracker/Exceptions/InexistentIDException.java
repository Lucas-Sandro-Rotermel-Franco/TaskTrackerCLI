package LucasRotermel.TaskTracker.Exceptions;

public class InexistentIDException extends RuntimeException {
    public InexistentIDException() {
        super("The id informed doesn't exist! Please validate it.");
    }
}

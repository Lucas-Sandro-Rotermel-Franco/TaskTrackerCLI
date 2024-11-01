package LucasRotermel.TaskTracker.Exceptions;

public class IdentifierInexistentException extends RuntimeException {
    public IdentifierInexistentException() {
        super("The informed id doesn't exists in our list.");
    }
}

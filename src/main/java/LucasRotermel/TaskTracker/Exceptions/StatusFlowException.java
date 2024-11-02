package LucasRotermel.TaskTracker.Exceptions;

public class StatusFlowException extends RuntimeException {
    public StatusFlowException() {
        super("The task is already in this status or is bypassing the defined flow, please validate it!");
    }
}

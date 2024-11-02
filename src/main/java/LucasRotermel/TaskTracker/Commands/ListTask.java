package LucasRotermel.TaskTracker.Commands;

import LucasRotermel.TaskTracker.Exceptions.ArgumentQuantityException;
import LucasRotermel.TaskTracker.Exceptions.IncorrectExecuteException;
import LucasRotermel.TaskTracker.Exceptions.InvalidArgumentStatusException;
import LucasRotermel.TaskTracker.Manager.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTask extends Command{
    private static final List<String> validStatus = Collections.unmodifiableList(
            new ArrayList<>() {{
                add("todo");
                add("in-progress");
                add("done");
            }});

    @Override
    public List<Task> execute(List<Task> tasks, String[] args) {
        if (args.length > 2)
            throw new ArgumentQuantityException(args.length - 1, "list", "1 or 0");

        boolean filterList = args.length > 1;

        String statusFilter = "";
        if (filterList) {
            statusFilter = args[1];
            if (!isStatusValid(statusFilter))
                throw new InvalidArgumentStatusException();
        }

        for (Task task : tasks) {
            if (filterList && !task.getStatus().equals(statusFilter))
                continue;

            List<String> tasksParameters = new ArrayList<>();
            tasksParameters.add("Task "          + task.getId());
            tasksParameters.add("Description: "  + task.getDescription());
            tasksParameters.add("Status: "       + task.getStatus());
            tasksParameters.add("Date updated: " + task.getDtUpdated());
            tasksParameters.add("Date created: " + task.getDtCreated());

            int biggestStringLength = obtainBiggestString(tasksParameters);

            tasksParameters = centerValues(tasksParameters, biggestStringLength);

            System.out.println("╔"  + "═".repeat(biggestStringLength + 2) +  "╗");
            System.out.println("║ " + tasksParameters.get(0)          + " ║");
            System.out.println("║ " + tasksParameters.get(1)          + " ║");
            System.out.println("║ " + tasksParameters.get(2)          + " ║");
            System.out.println("║ " + tasksParameters.get(3)          + " ║");
            System.out.println("║ " + tasksParameters.get(4)          + " ║");
            System.out.println("╚"  + "═".repeat(biggestStringLength + 2) +  "╝");
        }

        return tasks;
    }

    private List<String> centerValues(List<String> tasksParameters, int biggestStringLength) {
        int spaceQuantityBySide;
        String parameter;
        String space;
        int differenceBetweenLengths;

        for (int idx = 0; idx < tasksParameters.size(); idx++) {
            parameter = tasksParameters.get(idx);

            if (parameter.length() == biggestStringLength)
                continue;
            differenceBetweenLengths = biggestStringLength - parameter.length();
            spaceQuantityBySide = differenceBetweenLengths / 2;

            space = " ".repeat(spaceQuantityBySide);

            tasksParameters.set(idx, space + parameter + space + (differenceBetweenLengths % 2 == 0 ? "" : " "));
        }

        return tasksParameters;
    }

    private int obtainBiggestString(List<String> tasksParameters) {
        List<String> tasksParametersSorted = new ArrayList<>(tasksParameters);

        Collections.sort(tasksParametersSorted, (parameter1, parameter2) -> parameter2.length() - parameter1.length());

        return tasksParametersSorted.get(0).length();
    }

    private boolean isStatusValid(String statusFilter) {
        for (String status : validStatus) {
            if (status.equals(statusFilter))
                return true;
        }

        return false;
    }

    @Override
    public void execute() {
        throw new IncorrectExecuteException();
    }
}

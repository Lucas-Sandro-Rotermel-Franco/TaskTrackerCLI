package LucasRotermel.TaskTracker.Manager;

import LucasRotermel.TaskTracker.Commands.*;
import LucasRotermel.TaskTracker.Exceptions.CommandDontExistsException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskTrackerManager {
    private Path FILE        = Path.of("task_tracker.json");
    private Path FILE_BACKUP        = Path.of("task_tracker_bkp.json");
    private int lastId = 0;

    public void init(String[] args) {
        File file = new File(FILE.toString());
        File fileBkp;

        try {
             if (!file.exists()) {
                 file.createNewFile();
             }

             fileBkp = new File(FILE_BACKUP.toString());
             fileBkp.createNewFile();
        } catch (IOException e) {
            System.out.println("An error ocurred.");
            e.printStackTrace();
        }

        List<Task> tasks = getTasks(file);

        switch (args[0]) {
            case "add"             : tasks = executeCommand(new Add           (lastId), args, tasks); break;
            case "delete"          : tasks = executeCommand(new Delete        ()      , args, tasks); break;
            case "list"            : tasks = executeCommand(new ListTask      ()      , args, tasks); break;
            case "mark-done"       : tasks = executeCommand(new MarkDone      ()      , args, tasks); break;
            case "mark-in-progress": tasks = executeCommand(new MarkInProgress()      , args, tasks); break;
            case "update"          : tasks = executeCommand(new Update        ()      , args, tasks); break;
            case "--help"          : executeCommand        (new Help          ()                   ); break;
            default                : throw new CommandDontExistsException();
        }

        try {
            if (!args[0].equals("--help") && !args[0].equals("list"))
                Files.copy(FILE, FILE_BACKUP, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        writeFile(file, tasks);
    }

    private void writeFile(File file, List<Task> tasks) {
        try {
            FileWriter fWriter = new FileWriter(file);
            fWriter.write("[");

            for (int idx = 0; idx < tasks.size(); idx++) {;
                fWriter.write(tasks.get(idx).toString());

                if (idx < (tasks.size() - 1))
                    fWriter.write(",");
            }

            fWriter.write("]");
            fWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Task> getTasks(File file) {
        List<Task> tasks = new ArrayList<>();

        if (!Files.exists(FILE))
            return tasks;

        try {
            List<String> lines = Files.readAllLines(FILE);

            for (String line : lines) {
                line = line.replace("[", "")
                           .replace("{", "")
                           .replace("]","")
                           .replace("}","")
                           .replace("\"", "");

                List<String> jsonProperties = new ArrayList<>(Arrays.asList(line.split(",")));


                if (line.isEmpty())
                    continue;

                if (jsonProperties.get(0).equals(""))
                    jsonProperties.removeFirst();

                Task task = new Task();

                task.setId(Integer.parseInt(jsonProperties.get(0).split(": ")[1].strip()));
                task.setDescription(jsonProperties.get(1).split(": ")[1].strip());
                task.setStatus(jsonProperties.get(2).split(": ")[1].strip());
                task.setDtCreated(jsonProperties.get(3).split(": ")[1].strip());
                task.setDtUpdated(jsonProperties.get(4).split(": ")[1].strip());

                if (task.getId() > lastId)
                    lastId = task.getId();

                tasks.add(task);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tasks;
    }

    private List<Task> executeCommand(Command command, String[] args, List<Task> tasks) {
        tasks = command.execute(tasks, args);

        return tasks;
    }

    private void executeCommand(Command command) {
        command.execute();
    }
}

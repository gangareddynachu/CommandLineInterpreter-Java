package terminal;

import commands.dir.ChangeDirectory;
import commands.dir.DirectoryCommand;
import commands.ops.*;
import commands.print.*;
import commands.system.ExitCommand;
import commands.system.SystemCommand;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandSearch {
    private Map<String, Class> command = new HashMap<>();

    public CommandSearch() {
        command.put("help", HelpCommand.class);
        command.put("args", ArgsCommand.class);
        command.put("date", DateCommand.class);
        command.put("clear", ClearCommand.class);
        command.put("exit", ExitCommand.class);
        command.put("pwd", CurrentDirectoryCommand.class);
        command.put("cd", ChangeDirectory.class);
        command.put("mkdir", MakeDirectoryCommand.class);
        command.put("ls", ListFilesCommand.class);
        command.put("rmdir", RemoveDirectoryCommand.class);
        command.put("cat", ConcatenateCommand.class);
        command.put("rm", RemoveCommand.class);
        command.put("grep", GrepCommand.class);
        command.put("cp", CopyCommand.class);
        command.put("mv", MoveCommand.class);
        command.put("less", LessCommand.class);
        command.put("more", MoreCommand.class);
        command.put("echo",echoCommand.class);
    }

    public File findAndExecute(String c, File curr) throws IllegalAccessException, InstantiationException {
        String[] split = c.split("\\s+");
        String[] args = Arrays.copyOfRange(split, 1, split.length);
        Class commandClass = command.get(split[0]);

        if (commandClass == null) {
            System.out.println("Command not found.");
            return curr;
        }
        Object command = commandClass.newInstance();
        if (command instanceof PrintCommand) {
            try {
                ((PrintCommand) command).execute(args);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return curr;
        }

        if (command instanceof SystemCommand) {
            ((SystemCommand) command).execute();
            return curr;
        }

        if (command instanceof DirectoryCommand) {
            try {
                return ((DirectoryCommand) command).execute(curr, args);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return curr;
        }

        if (command instanceof OperationCommand) {
            try {
                ((OperationCommand) command).execute(curr, args);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return curr;
        }

        return null;
    }
}

package commands.print;

public class HelpCommand implements PrintCommand {

    @Override
    public void execute(String... args) throws IllegalArgumentException {
        if (args == null || args.length == 0) {
            displayHelp();
        } else
            throw new IllegalArgumentException("--------help takes no args.");
    }

    private void displayHelp() {
        System.out.println("date: Displays system date and time.");
        System.out.println("help: List all commands.");
        System.out.println("args: List all commands arguments.");
        System.out.println("clear: Clears the console.");
        System.out.println("cd: Changes current working directory.");
        System.out.println("ls: List all contents of current directory.");
        System.out.println("man: Displays command manual.");
        System.out.println("pwd: Displays the absolute path of current directory.");
        System.out.println("cp: Copies files.");
        System.out.println("mv: Moves files.");
        System.out.println("mkdir: Creates a new directory.");
        System.out.println("rmdir: Deletes a directory.");
        System.out.println("rm: Deletes a file or directory.");
        System.out.println("cat: Displays contents of a file and concatenates files and display output.");
        System.out.println("more: Displays and scroll down the output in one direction only.");
        System.out.println("less: Like more but more enhanced.");
        System.out.println("grep: get word in file.");
        System.out.println("exit: Terminates the program.");
    }

}

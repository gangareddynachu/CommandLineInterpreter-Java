package commands.print;

public class ArgsCommand implements PrintCommand {

    @Override
    public void execute(String... args) throws IllegalArgumentException {
        if (args == null || args.length == 0) {
            displayArgs();
        } else
            throw new IllegalArgumentException("---------args takes no args.");
    }

    private void displayArgs() {
        System.out.println("cd: [arg] changes working directory to the given arg.");
        System.out.println("cd: [no arg] changes working directory to current directory.");
        System.out.println("ls: [no arg] displays contents of a file.");
        System.out.println("ls: [-a] displays contents of a file including hidden files.");
        System.out.println("cp: [arg1] [arg2] copies contents of arg1(file) to arg2(file).");
        System.out.println("cp: [arg1] [arg2] [argN] copies all given arguments from arg1->argN-1 to directory argN.");
        System.out.println("mv: [arg1] [arg2] copies contents of arg1(file) to arg2(file) and deletes arg1.");
        System.out.println("cp: [arg1] [arg2] [argN] moves all given arguments from arg1->argN-1 to directory argN.");
        System.out.println("mkdir: [arg] creates a directory with whose name is the given argument.");
        System.out.println("rmdir: [arg] deletes a directory whose name is given argument.");
        System.out.println("rm: [arg] deletes a file whose name is the given argument.");
        System.out.println("cat: [arg1] displays contents of arg1(file).");
        System.out.println("cat: [arg1] [arg2] concatenates contents of arg1 to contents of arg2 and displays the result.");
        System.out.println("grep: [arg1] [arg2] get lines of occurrences of arg1 in file arg2.");
    }
}

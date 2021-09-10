package commands.system;

public class ExitCommand implements SystemCommand {
    @Override
    public void execute() {
        System.exit(0);
    }
}

package commands.print;

public class ClearCommand implements PrintCommand {

    @Override
    public void execute(String... args) throws IllegalArgumentException {
        if (args == null || args.length == 0) {
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }
        } else
            throw new IllegalArgumentException("---------clear takes no args.");
    }
}

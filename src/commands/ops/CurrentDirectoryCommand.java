package commands.ops;

import java.io.File;

public class CurrentDirectoryCommand extends OperationCommand {

    @Override
    public void execute(File curr, String... args) throws IllegalArgumentException {
        if (args == null || args.length == 0) {
            System.out.println(curr.getAbsolutePath());
        } else
            throw new IllegalArgumentException("-------pwd takes no args.");
    }
}

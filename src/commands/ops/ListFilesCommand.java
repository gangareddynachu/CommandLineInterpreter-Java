package commands.ops;

import java.io.File;
import java.util.Arrays;

public class ListFilesCommand extends OperationCommand {

    @Override
    public void execute(File curr, String... args) throws Exception {
        if (args.length > 1) {
            throw new IllegalArgumentException("-----------Too many args");
        }
        if (args.length > 0 && !args[0].equals("-a")) {
            throw new IllegalArgumentException("-------------Bad Flag");
        }
        boolean hidden = false;
        if (args.length > 0) hidden = true;
        if (hidden)
            Arrays.stream(curr.listFiles()).forEach(file -> System.out.println(file.getName()));
        else
            Arrays.stream(curr.listFiles()).filter(file -> !file.isHidden()).
                    forEach(file -> System.out.println(file.getName()));
    }
}

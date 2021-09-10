package commands.ops;

import commands.helpers.FileHelper;

import java.io.File;

public class MakeDirectoryCommand extends OperationCommand {

    @Override
    public void execute(File curr, String... args) throws Exception {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("-----Too few args.");
        }
        for (String arg : args) {
            fileHelper.touchDir(curr, arg);
        }
    }

}

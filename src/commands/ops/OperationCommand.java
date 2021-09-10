package commands.ops;

import commands.helpers.FileHelper;

import java.io.File;

public abstract class OperationCommand {
    protected FileHelper fileHelper = new FileHelper();

    public abstract void execute(File curr, String... args) throws Exception;
}

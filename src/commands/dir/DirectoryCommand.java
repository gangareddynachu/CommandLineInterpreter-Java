package commands.dir;

import commands.helpers.FileHelper;

import java.io.File;

public abstract class DirectoryCommand {
    protected FileHelper fileHelper = new FileHelper();

    public abstract File execute(File curr, String... args) throws Exception;
}

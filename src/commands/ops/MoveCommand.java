package commands.ops;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class MoveCommand extends OperationCommand {

    @Override
    public void execute(File curr, String... args) throws Exception {
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("---------Too few args.");
        }
        String finalDir = args[args.length - 1];
        File target = fileHelper.getDir(curr, finalDir);
        for (int i = 0; i < args.length - 1; i++) {
            try {
                File f = fileHelper.getFile(curr, args[i]);
                Files.move(f.toPath(), target.toPath().resolve(f.toPath().getFileName()),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

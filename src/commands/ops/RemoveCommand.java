package commands.ops;

import java.io.File;

public class RemoveCommand extends OperationCommand {

    @Override
    public void execute(File curr, String... args) throws Exception {
        if (args == null || args.length < 1) {
            throw new IllegalArgumentException("---------Too few args.");
        }
        for (String arg : args) {
            try {
                fileHelper.getFile(curr, arg).delete();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

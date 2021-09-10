package commands.ops;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrepCommand extends OperationCommand {

    @Override
    public void execute(File curr, String... args) throws Exception {
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("---------Too few args.");
        }
        if (args == null || args.length > 2) {
            throw new IllegalArgumentException("---------Too many args.");
        }
        File target = fileHelper.getFile(curr, args[1]);
        grep(target, args[0]);
    }

    private void grep(File f, String word) throws FileNotFoundException {
        try (Scanner input = new Scanner(f)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains(word)) {
                    System.out.println(line);
                }
            }
        }
    }

}

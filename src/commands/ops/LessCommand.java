package commands.ops;

import java.io.*;
import java.util.Scanner;

public class LessCommand extends OperationCommand {

    @Override
    public void execute(File curr, String... args) throws Exception {
        if (args == null || args.length < 1) {
            throw new IllegalArgumentException("---------Too few args.");
        }
        if (args.length > 1) {
            throw new IllegalArgumentException("---------Too many args.");
        }
        less(fileHelper.getFile(curr, args[0]));
    }

    private void less(File f) throws IOException {
        String choice = "q";
        try (FileInputStream a = new FileInputStream(f); BufferedReader input = new BufferedReader(new InputStreamReader(a));) {
            Scanner sc = new Scanner(System.in);
            do {
                int x = 0;
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                    if (++x == 10) break;
                }
                System.out.println("Press q to exit! else for more");
                choice = sc.nextLine();
            } while (!choice.equals("q"));
        }
    }
}

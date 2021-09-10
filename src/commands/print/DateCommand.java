package commands.print;

import java.util.Date;

public class DateCommand implements PrintCommand {
    @Override
    public void execute(String... args) throws IllegalArgumentException {
        if (args == null || args.length == 0) {
            System.out.println(new Date());
        } else
            throw new IllegalArgumentException("--------date takes no args.");
    }

}

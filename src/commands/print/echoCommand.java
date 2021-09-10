package commands.print;

import java.util.Date;


public class echoCommand implements PrintCommand {
    @Override
    public void execute(String... args) throws IllegalArgumentException {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("echo requires more than one arguments");
        } else
        {
           for(String s : args)
           {
               System.out.print(s);
               System.out.print(" ");

        }

        }
    }

}

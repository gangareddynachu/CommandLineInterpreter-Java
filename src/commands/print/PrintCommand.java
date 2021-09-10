package commands.print;

import java.util.Date;

public interface PrintCommand {
    void execute(String... args) throws IllegalArgumentException;
}


package commands.helpers;

import java.io.File;
import java.io.FileNotFoundException;

public class FileHelper {

    public File getDir(File curr, String targetPath) throws FileNotFoundException {
        File target = new File(targetPath);
        if (target.isAbsolute()) {
            if (target.exists() && target.isDirectory()) return target;
            if (target.exists() && !target.isDirectory())
                throw new IllegalArgumentException(String.format("---------%s isn't a dir.", targetPath));
            else throw new FileNotFoundException(String.format("---------%s doesn't exist.", targetPath));
        }
        String path = String.format("%s/%s", curr.getAbsolutePath(), targetPath);
        target = new File(path);
        if (target.exists()) {
            if (!target.isDirectory())
                throw new IllegalArgumentException(String.format("---------%s isn't a dir.", targetPath));
            return target;
        } else throw new FileNotFoundException(String.format("------------%s doesn't exist.", targetPath));
    }

    public void touchDir(File curr, String newDir) {
        File target = new File(newDir);
        if (!target.isAbsolute()) {
            String path = String.format("%s/%s", curr.getAbsolutePath(), newDir);
            target = new File(path);
        }
        target.mkdir();
    }

    public File getFile(File curr, String targetPath) throws FileNotFoundException {
        File target = new File(targetPath);
        if (target.isAbsolute()) {
            if (target.exists() && !target.isDirectory()) return target;
            if (target.exists() && target.isDirectory())
                throw new IllegalArgumentException(String.format("---------%s isn't a file.", targetPath));
            else throw new FileNotFoundException(String.format("---------%s doesn't exist.", targetPath));
        }
        String path = String.format("%s/%s", curr.getAbsolutePath(), targetPath);
        target = new File(path);
        if (target.exists()) {
            if (target.isDirectory())
                throw new IllegalArgumentException(String.format("---------%s isn't a file.", targetPath));
            return target;
        } else throw new FileNotFoundException(String.format("------------%s doesn't exist.", targetPath));
    }
}

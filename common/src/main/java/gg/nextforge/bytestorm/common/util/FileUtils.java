package gg.nextforge.bytestorm.common.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@UtilityClass
public class FileUtils {
    public void ensureDir(Path dir) throws IOException {
        if (Files.notExists(dir)) Files.createDirectories(dir);
    }
}
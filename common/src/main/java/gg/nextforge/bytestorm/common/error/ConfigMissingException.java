package gg.nextforge.bytestorm.common.error;

public class ConfigMissingException extends RuntimeException {
    public ConfigMissingException(String message) {
        super("Missing config source: " + message);
    }

}

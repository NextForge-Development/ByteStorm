package gg.nextforge.bytestorm.common.error;

public class ByteStormException extends RuntimeException {
    public ByteStormException(String message) {
        super(message);
    }

    public ByteStormException(String message, Throwable cause) {
        super(message, cause);
    }

}

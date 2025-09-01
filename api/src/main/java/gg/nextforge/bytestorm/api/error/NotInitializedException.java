package gg.nextforge.bytestorm.api.error;

import gg.nextforge.bytestorm.common.error.ByteStormException;

public final class NotInitializedException extends ByteStormException {
    public NotInitializedException(String msg) { super("API Error: " + msg); }
}

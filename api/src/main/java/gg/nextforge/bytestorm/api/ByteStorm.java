package gg.nextforge.bytestorm.api;

import gg.nextforge.bytestorm.api.error.NotInitializedException;
import lombok.NonNull;
import java.util.Objects;

/** Static entrypoint used by plugins to access the cloud services. */
public final class ByteStorm {
    private static volatile ByteStormProvider provider;

    private ByteStorm() {}

    /** Called by the core at bootstrap time. */
    public static void setProvider(@NonNull ByteStormProvider p) {
        provider = Objects.requireNonNull(p, "provider");
    }

    /** Returns the current provider or throws if not initialized. */
    public static @NonNull ByteStormProvider require() {
        var p = provider;
        if (p == null) throw new NotInitializedException("ByteStorm API not initialized");
        return p;
    }

    /** Returns the current provider or null if not initialized. */
    public static ByteStormProvider get() { return provider; }
}

package gg.nextforge.bytestorm.common.util;

import java.util.concurrent.ThreadFactory;

public final class NamedThreadFactory implements ThreadFactory {
    private final String prefix;
    private int c = 0;

    public NamedThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, prefix + "-" + (c++));
    }
}

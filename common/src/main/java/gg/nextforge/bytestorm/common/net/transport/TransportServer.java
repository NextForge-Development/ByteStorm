package gg.nextforge.bytestorm.common.net.transport;

import java.util.function.Consumer;

public interface TransportServer extends AutoCloseable {
    void bind(String channel, Consumer<byte[]> consumer) throws Exception;

    @Override
    void close() throws Exception;
}

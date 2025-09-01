package gg.nextforge.bytestorm.common.net.transport;

public interface Transport extends AutoCloseable {
    void send(String channel, byte[] data) throws Exception;

    @Override
    void close() throws Exception;
}

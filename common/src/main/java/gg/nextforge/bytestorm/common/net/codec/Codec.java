package gg.nextforge.bytestorm.common.net.codec;

public interface Codec<T> {
    byte[] encode(T value);

    T decode(byte[] bytes);
}


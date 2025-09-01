package gg.nextforge.bytestorm.common.serialize;

import java.io.Serializable;

public interface Serializer<T extends Serializable> {
    byte[] write(T value);

    T read(byte[] bytes);
}

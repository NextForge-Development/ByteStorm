package gg.nextforge.bytestorm.common.serialize.impl;

import gg.nextforge.bytestorm.common.serialize.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class JavaSerializer<T extends Serializable> implements Serializer<T> {

    public byte[] write(T v) {
        try (var baos = new ByteArrayOutputStream(); var out = new ObjectOutputStream(baos)) {
            out.writeObject(v);
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public T read(byte[] b) {
        try (var in = new ObjectInputStream(new ByteArrayInputStream(b))) {
            return (T) in.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
package gg.nextforge.bytestorm.common.net.codec.impl;

import gg.nextforge.bytestorm.common.net.codec.Codec;

public final class Utf8Codec implements Codec<String> {
    @Override
    public byte[] encode(String v) {
        return v.getBytes(java.nio.charset.StandardCharsets.UTF_8);
    }

    @Override
    public String decode(byte[] b) {
        return new String(b, java.nio.charset.StandardCharsets.UTF_8);
    }
}
package gg.nextforge.bytestorm.common.crypto;

import lombok.experimental.UtilityClass;

import java.security.MessageDigest;

@UtilityClass
public final class Digests {

    public byte[] sha256(byte[] in) {
        try {
            var md = MessageDigest.getInstance("SHA-256");
            return md.digest(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


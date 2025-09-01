package gg.nextforge.bytestorm.common.ids;

import java.util.UUID;

public record Id(UUID value) {

    public static Id random() {
        return new Id(UUID.randomUUID());
    }
}

package gg.nextforge.bytestorm.api.players;

import java.util.UUID;

public record PlayerId(UUID value) {
    public static PlayerId of(UUID v){ return new PlayerId(v); }
}

package gg.nextforge.bytestorm.api.players;

import java.time.Instant;

public record PlayerSession(PlayerId playerId, Instant connectedAt, String address) {}

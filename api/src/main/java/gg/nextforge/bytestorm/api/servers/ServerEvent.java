package gg.nextforge.bytestorm.api.servers;

import gg.nextforge.bytestorm.api.events.ByteStormEvent;

public sealed interface ServerEvent extends ByteStormEvent permits ServerEvent.Started, ServerEvent.Stopped, ServerEvent.Crashed {
    record Started(ServerId server) implements ServerEvent {
    }

    record Stopped(ServerId server) implements ServerEvent {
    }

    record Crashed(ServerId server, String reason) implements ServerEvent {
    }
}

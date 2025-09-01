package gg.nextforge.bytestorm.api.players;

import gg.nextforge.bytestorm.api.servers.ServerId;

public interface CloudPlayer {
    PlayerId id();
    String name();
    ServerId currentServer(); // may be null if not on a server yet
}

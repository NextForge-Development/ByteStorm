package gg.nextforge.bytestorm.api.players;

import gg.nextforge.bytestorm.api.events.ByteStormEvent;
import gg.nextforge.bytestorm.api.servers.ServerId;

public sealed interface PlayerEvent extends ByteStormEvent permits PlayerEvent.Join, PlayerEvent.Quit, PlayerEvent.SwitchServer {
    record Join(PlayerId playerId, String name) implements PlayerEvent {}
    record Quit(PlayerId playerId, String name) implements PlayerEvent {}
    record SwitchServer(PlayerId playerId, ServerId from, ServerId to) implements PlayerEvent {}
}

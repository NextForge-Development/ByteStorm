package gg.nextforge.bytestorm.core.domain;

import gg.nextforge.bytestorm.api.servers.CloudServer;
import gg.nextforge.bytestorm.api.servers.ServerId;
import gg.nextforge.bytestorm.api.servers.ServerState;
import gg.nextforge.bytestorm.api.servers.ServerType;
import gg.nextforge.bytestorm.api.templates.Template;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

@Getter
@Setter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CloudServerImpl implements CloudServer {
    ServerId id;
    String group;
    ServerType type;
    ServerState state;
    boolean online;
    int onlinePlayers;
    int maxPlayers;
    Template templateOverride;

    @Override
    public Optional<String> templateName() {
        return Optional.ofNullable(templateOverride != null ? templateOverride.name() : null);
    }
}

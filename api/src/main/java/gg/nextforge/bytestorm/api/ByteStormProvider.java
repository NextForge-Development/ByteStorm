package gg.nextforge.bytestorm.api;

import gg.nextforge.bytestorm.api.events.EventBus;
import gg.nextforge.bytestorm.api.groups.GroupService;
import gg.nextforge.bytestorm.api.permissions.PermissionService;
import gg.nextforge.bytestorm.api.players.PlayerService;
import gg.nextforge.bytestorm.api.servers.ServerService;
import gg.nextforge.bytestorm.api.status.StatusService;
import gg.nextforge.bytestorm.api.templates.TemplateService;
import gg.nextforge.bytestorm.api.query.QueryService;

/** Implemented by the core; provides access to all domain services. */
public interface ByteStormProvider {
    GroupService groups();
    PlayerService players();
    ServerService servers();
    TemplateService templates();

    PermissionService permissions();
    EventBus events();

    QueryService query();
    StatusService status();
}

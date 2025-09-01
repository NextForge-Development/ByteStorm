package gg.nextforge.bytestorm.core.bootstrap;

import gg.nextforge.bytestorm.api.ByteStormProvider;
import gg.nextforge.bytestorm.api.events.EventBus;
import gg.nextforge.bytestorm.api.groups.GroupService;
import gg.nextforge.bytestorm.api.permissions.PermissionService;
import gg.nextforge.bytestorm.api.players.PlayerService;
import gg.nextforge.bytestorm.api.query.QueryService;
import gg.nextforge.bytestorm.api.servers.ServerService;
import gg.nextforge.bytestorm.api.status.StatusService;
import gg.nextforge.bytestorm.api.templates.TemplateService;

public final class CoreProvider implements ByteStormProvider {
    private final GroupService groups;
    private final PlayerService players;
    private final ServerService servers;
    private final TemplateService templates;
    private final PermissionService permissions;
    private final EventBus events;
    private final QueryService query;
    private final StatusService status;

    public CoreProvider(GroupService groups, PlayerService players, ServerService servers, TemplateService templates,
                        PermissionService permissions, EventBus events,
                        QueryService query, StatusService status) {
        this.groups = groups;
        this.players = players;
        this.servers = servers;
        this.templates = templates;
        this.permissions = permissions;
        this.events = events;
        this.query = query;
        this.status = status;
    }

    @Override
    public GroupService groups() {
        return groups;
    }

    @Override
    public PlayerService players() {
        return players;
    }

    @Override
    public ServerService servers() {
        return servers;
    }

    @Override
    public TemplateService templates() {
        return templates;
    }

    @Override
    public PermissionService permissions() {
        return permissions;
    }

    @Override
    public EventBus events() {
        return events;
    }

    @Override
    public QueryService query() {
        return query;
    }

    @Override
    public StatusService status() {
        return status;
    }
}

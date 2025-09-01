package gg.nextforge.bytestorm.core.services;

import gg.nextforge.bytestorm.api.servers.CloudServer;
import gg.nextforge.bytestorm.api.servers.ServerId;
import gg.nextforge.bytestorm.api.servers.ServerService;
import gg.nextforge.bytestorm.api.servers.ServerType;
import gg.nextforge.bytestorm.core.domain.CloudServerImpl;
import lombok.NonNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ServerServiceImpl implements ServerService {
    private Map<String, CloudServer> cloudServers;

    private final GroupServiceImpl groupService;

    public ServerServiceImpl(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    public CloudServer add(CloudServerImpl s) {
        if (groupService.byName(s.group()) == null)
            throw new IllegalArgumentException("Unknown group: " + s.group());
        String effectiveName = s.group() + "-" + (cloudServers.keySet().stream().filter(str -> str.startsWith(s.group() + "-")).count() + 1);
        ServerId serverId = new ServerId(effectiveName);
        s.id(serverId);
        cloudServers.put(effectiveName, s);
        return s;
    }

    @Override
    public Optional<CloudServer> byId(@NonNull ServerId id) {
        return Optional.ofNullable(cloudServers.get(id.value()));
    }

    @Override
    public Optional<CloudServer> byName(@NonNull String name) {
        return Optional.ofNullable(cloudServers.get(name));
    }

    @Override
    public Optional<List<CloudServer>> byGroup(@NonNull String group) {
        List<CloudServer> servers = cloudServers.values().stream().filter(s -> s.group().equals(group)).toList();
        return servers.isEmpty() ? Optional.empty() : Optional.of(servers);
    }

    @Override
    public Optional<List<CloudServer>> byType(@NonNull ServerType type) {
        List<CloudServer> servers = cloudServers.values().stream().filter(s -> s.type() == type).toList();
        return servers.isEmpty() ? Optional.empty() : Optional.of(servers);
    }

    @Override
    public Collection<CloudServer> all() {
        return Collections.unmodifiableCollection(cloudServers.values());
    }

    @Override
    public void start() throws Exception {
        cloudServers = new ConcurrentHashMap<>();
    }

    @Override
    public void stop() throws Exception {
        cloudServers.clear();
    }
}

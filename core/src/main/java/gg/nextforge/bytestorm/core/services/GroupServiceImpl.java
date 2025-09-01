package gg.nextforge.bytestorm.core.services;

import gg.nextforge.bytestorm.api.ByteStorm;
import gg.nextforge.bytestorm.api.groups.GroupId;
import gg.nextforge.bytestorm.api.groups.GroupService;
import gg.nextforge.bytestorm.api.groups.GroupType;
import gg.nextforge.bytestorm.api.groups.ServerGroup;
import gg.nextforge.bytestorm.api.templates.Template;
import gg.nextforge.bytestorm.api.templates.TemplateService;
import gg.nextforge.bytestorm.core.domain.ServerGroupImpl;
import lombok.NonNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GroupServiceImpl implements GroupService {

    private final Map<String, ServerGroup> serverGroups = new ConcurrentHashMap<>();

    protected ServerGroup add(@NonNull ServerGroupImpl group) {
            // Create specified template if it does not exist
            if (group.templateName() != null && !group.templateName().isEmpty()) {
                TemplateService templateService = ByteStorm.get().templates();
                Template newTemplate = templateService.create(group.templateName());
                templateService.add(newTemplate);
                template = newTemplate;
            }
        }
        GroupId id = new GroupId(group.name().toLowerCase());
        group.id(id);
        ServerGroup existing = serverGroups.putIfAbsent(group.name().toLowerCase(), group);
        return existing == null ? group : existing;
    }

    @Override
    public Optional<ServerGroup> byId(@NonNull GroupId id) {
        return serverGroups.values().stream().filter(g -> g.id().equals(id)).findFirst();
    }

    @Override
    public Optional<ServerGroup> byName(@NonNull String name) {
        return Optional.ofNullable(serverGroups.get(name.toLowerCase()));
    }

    @Override
    public Optional<List<ServerGroup>> byType(@NonNull GroupType type) {
        List<ServerGroup> groups = serverGroups.values().stream().filter(g -> g.type() == type).toList();
        return groups.isEmpty() ? Optional.empty() : Optional.of(groups);
    }

    @Override
    public Collection<ServerGroup> all() {
        return Collections.unmodifiableCollection(serverGroups.values());
    }

    @Override
    public void start() throws Exception {
        // Initial setup if needed
    }

    @Override
    public void stop() throws Exception {
        serverGroups.clear();
    }
}

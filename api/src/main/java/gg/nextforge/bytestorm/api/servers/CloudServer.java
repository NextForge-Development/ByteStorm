package gg.nextforge.bytestorm.api.servers;

import gg.nextforge.bytestorm.api.groups.ServerGroup;

import java.util.Optional;

public interface CloudServer {
    ServerId id();
    String group();
    ServerType type();
    ServerState state();
    boolean online();
    int onlinePlayers();
    int maxPlayers();

    /**
     * Optional server-scoped template override.
     * If empty, the group's template is used.
     */
    Optional<String> templateName();

    /**
     * Resolve the effective template name for this server,
     * falling back to the provided group's template.
     */
    default String effectiveTemplateName(ServerGroup group) {
        String groupTemplate = group.templateName();
        if (groupTemplate == null || groupTemplate.isBlank()) {
            throw new IllegalStateException("Group '" + group.name() + "' has no templateName()");
        }
        return templateName().filter(s -> !s.isBlank()).orElse(groupTemplate);
    }
}

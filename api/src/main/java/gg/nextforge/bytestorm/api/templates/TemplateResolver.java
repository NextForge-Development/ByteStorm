package gg.nextforge.bytestorm.api.templates;

import gg.nextforge.bytestorm.api.groups.ServerGroup;
import gg.nextforge.bytestorm.api.servers.CloudServer;

import java.util.Objects;

/** Utility methods to resolve effective template names. */
public final class TemplateResolver {
    private TemplateResolver() {}

    /**
     * Server-level override wins; otherwise group's template.
     */
    public static String effectiveTemplateName(CloudServer server, ServerGroup group) {
        Objects.requireNonNull(server, "server");
        Objects.requireNonNull(group, "group");
        String groupTemplate = group.templateName();
        if (groupTemplate == null || groupTemplate.isBlank()) {
            throw new IllegalStateException("Group '"+ group.name() +"' has no templateName()");
        }
        return server.templateName().filter(s -> !s.isBlank()).orElse(groupTemplate);
    }
}

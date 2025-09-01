package gg.nextforge.bytestorm.core.templates;

import gg.nextforge.bytestorm.api.ByteStorm;
import gg.nextforge.bytestorm.api.groups.ServerGroup;
import gg.nextforge.bytestorm.api.servers.CloudServer;
import gg.nextforge.bytestorm.api.templates.Template;
import java.util.Objects;

public final class EffectiveTemplate {
    private EffectiveTemplate() {}

    /** Server-Override gewinnt; sonst Gruppen-Template (muss vorhanden sein). */
    public static Template resolve(CloudServer server, ServerGroup group) {
        Objects.requireNonNull(server, "server");
        Objects.requireNonNull(group, "group");
        if (server.templateName() != null) {
            Template serverTemplate = ByteStorm.get().templates().byName(server.templateName()).orElse(null);
            if (serverTemplate != null) {
                return serverTemplate;
            }
        }
        return groupTemplate;
    }
}

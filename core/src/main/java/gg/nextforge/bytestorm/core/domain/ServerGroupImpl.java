package gg.nextforge.bytestorm.core.domain;

import gg.nextforge.bytestorm.api.groups.GroupId;
import gg.nextforge.bytestorm.api.groups.GroupType;
import gg.nextforge.bytestorm.api.groups.ScalingPolicy;
import gg.nextforge.bytestorm.api.groups.ServerGroup;
import gg.nextforge.bytestorm.api.templates.Template;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServerGroupImpl implements ServerGroup {
    GroupId id;
    String name;
    GroupType type;
    int minOnline;
    int maxOnline;
    ScalingPolicy scaling;

    Template template;

    @Override
    public String templateName() {
        return this.template.name();
    }
}

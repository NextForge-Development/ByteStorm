package gg.nextforge.bytestorm.api.groups;

public interface ServerGroup {
    GroupId id();
    String name();
    GroupType type();
    int minOnline();
    int maxOnline();
    ScalingPolicy scaling();

    String templateName(); // REQUIRED
}

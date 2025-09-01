package gg.nextforge.bytestorm.api.status;

import java.util.List;

public record CloudStatus(VersionInfo version, List<NodeStatus> nodes, Health overall) {}

package gg.nextforge.bytestorm.api.status;

public record NodeStatus(String nodeId, Health health, Uptime uptime) {}

package gg.nextforge.bytestorm.api.groups;

public record ScalingPolicy(int minInstances, int maxInstances, double scaleUpAtCpu, double scaleDownAtCpu) {}

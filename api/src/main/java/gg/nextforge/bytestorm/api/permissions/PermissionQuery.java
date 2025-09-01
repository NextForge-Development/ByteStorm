package gg.nextforge.bytestorm.api.permissions;

public record PermissionQuery(SubjectRef subject, Permission permission, String contextServer) {}

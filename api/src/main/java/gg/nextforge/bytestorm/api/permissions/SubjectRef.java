package gg.nextforge.bytestorm.api.permissions;

public record SubjectRef(String type, String identifier) {
    public static SubjectRef ofPlayer(String uuid) { return new SubjectRef("player", uuid); }
}

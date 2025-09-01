package gg.nextforge.bytestorm.api.groups;

public record GroupId(String value) {
    public static GroupId of(String v) {
        return new GroupId(v);
    }
}

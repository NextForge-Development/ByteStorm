package gg.nextforge.bytestorm.api.servers;

public record ServerId(String value) {
    public static ServerId of(String v){ return new ServerId(v); }
}

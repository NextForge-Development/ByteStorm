package gg.nextforge.bytestorm.common.config.model;

public sealed interface Value permits Value.StringValue, Value.IntValue, Value.BoolValue {
    record StringValue(String v) implements Value {}
    record IntValue(int v) implements Value {}
    record BoolValue(boolean v) implements Value {}
}
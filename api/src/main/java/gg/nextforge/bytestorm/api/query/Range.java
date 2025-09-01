package gg.nextforge.bytestorm.api.query;

public record Range(int offset, int limit) {
    public static Range ofPage(int page, int size){ return new Range(Math.max(0, page)*size, size); }
}

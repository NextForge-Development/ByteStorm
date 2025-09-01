package gg.nextforge.bytestorm.api.query;

public record Sort(String field, boolean ascending) {
    public static Sort asc(String f){ return new Sort(f, true); }
    public static Sort desc(String f){ return new Sort(f, false); }
}

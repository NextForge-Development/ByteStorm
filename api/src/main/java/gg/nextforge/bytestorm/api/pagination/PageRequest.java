package gg.nextforge.bytestorm.api.pagination;

public record PageRequest(int page, int size) {
    public int offset(){ return Math.max(0, page) * size; }
}

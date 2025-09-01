package gg.nextforge.bytestorm.api.pagination;

import java.util.List;

public record Slice<T>(List<T> content, boolean hasNext) {}

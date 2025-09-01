package gg.nextforge.bytestorm.api.query;

import java.util.List;

public record QueryResult<T>(List<T> items, long total) {}

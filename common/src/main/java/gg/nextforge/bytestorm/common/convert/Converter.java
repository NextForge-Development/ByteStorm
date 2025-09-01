package gg.nextforge.bytestorm.common.convert;

public interface Converter<S, T> {
    T convert(S source);
}

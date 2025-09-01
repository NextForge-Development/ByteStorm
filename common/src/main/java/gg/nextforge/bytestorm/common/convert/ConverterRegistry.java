package gg.nextforge.bytestorm.common.convert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConverterRegistry {
    private final Map<Key<?, ?>, Converter<?, ?>> converters = new ConcurrentHashMap<>();

    public <S, T> void register(Class<S> sourceType, Class<T> targetType, Converter<S, T> converter) {
        converters.put(new Key<>(sourceType, targetType), converter);
    }

    @SuppressWarnings("unchecked")
    public <S, T> Converter<S, T> getConverter(Class<S> sourceType, Class<T> targetType) {
        return (Converter<S, T>) converters.get(new Key<>(sourceType, targetType));
    }

    public <S, T> T convert(S source, Class<T> targetType) {
        if (source == null) return null;
        @SuppressWarnings("unchecked")
        Class<S> sourceType = (Class<S>) source.getClass();
        Converter<S, T> converter = getConverter(sourceType, targetType);
        if (converter == null) {
            throw new IllegalArgumentException("No converter registered for " + sourceType.getName() + " to " + targetType.getName());
        }
        return converter.convert(source);
    }

    private record Key<S, T>(Class<S> sourceType, Class<T> targetType) {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key<?, ?> key = (Key<?, ?>) o;
            return sourceType.equals(key.sourceType) && targetType.equals(key.targetType);
        }

    }
}
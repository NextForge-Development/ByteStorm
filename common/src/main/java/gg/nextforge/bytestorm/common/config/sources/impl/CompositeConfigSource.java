package gg.nextforge.bytestorm.common.config.sources.impl;

import gg.nextforge.bytestorm.common.config.sources.ConfigSource;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public final class CompositeConfigSource implements ConfigSource {

    private final List<ConfigSource> configSources;

    @Override
    public Optional<String> get(String key) {
        for (ConfigSource source : configSources) {
            Optional<String> value = source.get(key);
            if (value.isPresent()) {
                return value;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getInt(String key) {
        for (ConfigSource source : configSources) {
            Optional<Integer> value = source.getInt(key);
            if (value.isPresent()) {
                return value;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> getBoolean(String key) {
        for (ConfigSource source : configSources) {
            Optional<Boolean> value = source.getBoolean(key);
            if (value.isPresent()) {
                return value;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Float> getFloat(String key) {
        for (ConfigSource source : configSources) {
            Optional<Float> value = source.getFloat(key);
            if (value.isPresent()) {
                return value;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Long> getLong(String key) {
        for (ConfigSource source : configSources) {
            Optional<Long> value = source.getLong(key);
            if (value.isPresent()) {
                return value;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Double> getDouble(String key) {
        for (ConfigSource source : configSources) {
            Optional<Double> value = source.getDouble(key);
            if (value.isPresent()) {
                return value;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<String[]> getStringArray(String key) {
        for (ConfigSource source : configSources) {
            Optional<String[]> value = source.getStringArray(key);
            if (value.isPresent()) {
                return value;
            }
        }
        return Optional.empty();
    }

    @Override
    public <T extends Enum<?>> Optional<T> getEnum(String key, Class<T> enumType) {
        for (ConfigSource source : configSources) {
            Optional<T> value = source.getEnum(key, enumType);
            if (value.isPresent()) {
                return value;
            }
        }
        return Optional.empty();
    }

    @Override
    public <T> Optional<T> getObject(String key, Class<T> type) {
        for (ConfigSource source : configSources) {
            Optional<T> value = source.getObject(key, type);
            if (value.isPresent()) {
                return value;
            }
        }
        return Optional.empty();
    }
}

package gg.nextforge.bytestorm.common.config.sources.impl;

import gg.nextforge.bytestorm.common.config.sources.ConfigSource;

import java.util.Optional;

public final class SystemPropertyConfigSource implements ConfigSource {
    @Override
    public Optional<String> get(String key) {
        return Optional.ofNullable(System.getProperty(key));
    }

    @Override
    public Optional<Integer> getInt(String key) {
        return get(key).flatMap(v -> {
            try {
                return Optional.of(Integer.parseInt(v));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        });
    }

    @Override
    public Optional<Boolean> getBoolean(String key) {
        return get(key).flatMap(v -> {
            if (v.equalsIgnoreCase("true") || v.equalsIgnoreCase("false")) {
                return Optional.of(Boolean.parseBoolean(v));
            } else {
                return Optional.empty();
            }
        });
    }

    @Override
    public Optional<Float> getFloat(String key) {
        return get(key).flatMap(v -> {
            try {
                return Optional.of(Float.parseFloat(v));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        });
    }

    @Override
    public Optional<Long> getLong(String key) {
        return get(key).flatMap(v -> {
            try {
                return Optional.of(Long.parseLong(v));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        });
    }

    @Override
    public Optional<Double> getDouble(String key) {
        return get(key).flatMap(v -> {
            try {
                return Optional.of(Double.parseDouble(v));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        });
    }

    @Override
    public Optional<String[]> getStringArray(String key) {
        return get(key).map(v -> v.split(","));
    }

    @Override
    public <T extends Enum<?>> Optional<T> getEnum(String key, Class<T> enumType) {
        return get(key).flatMap(v -> {
            try {
                @SuppressWarnings("unchecked")
                T enumValue = (T) Enum.valueOf((Class<Enum>) enumType, v);
                return Optional.of(enumValue);
            } catch (IllegalArgumentException e) {
                return Optional.empty();
            }
        });
    }

    @Override
    public <T> Optional<T> getObject(String key, Class<T> type) {
        throw new UnsupportedOperationException("Deserialization of complex objects is not supported from system properties.");
    }
}

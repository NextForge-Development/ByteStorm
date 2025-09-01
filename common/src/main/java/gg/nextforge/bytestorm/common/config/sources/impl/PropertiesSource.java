package gg.nextforge.bytestorm.common.config.sources.impl;

import gg.nextforge.bytestorm.common.config.sources.ConfigSource;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Properties;

public class PropertiesSource implements ConfigSource {

    private final Path file;
    private final Properties properties;

    public PropertiesSource(Path file) {
        this.file = file;

        this.properties = new Properties();
        try (var reader = Files.newBufferedReader(file)) {
            this.properties.load(reader);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties from file: " + file, e);
        }
    }

    @Override
    public Optional<String> get(String key) {
        return Optional.ofNullable(properties.getProperty(key));
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

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Enum<?>> Optional<T> getEnum(String key, Class<T> enumType) {
        return (Optional<T>) get(key).flatMap(v -> {
            try {
                return Optional.of(Enum.valueOf((Class<Enum>) enumType, v));
            } catch (IllegalArgumentException e) {
                return Optional.empty();
            }
        });
    }

    @Override
    public <T> Optional<T> getObject(String key, Class<T> type) {
        // Environment variables are strings; complex object deserialization is not supported.
        throw new UnsupportedOperationException("Deserialization of complex objects is not supported from properties files.");
    }
}

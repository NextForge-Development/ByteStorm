package gg.nextforge.bytestorm.common.config.sources;

import java.util.Optional;

/** A simple key/value source abstraction (env, system props, files, etc.). */
public interface ConfigSource {

    Optional<String> get(String key);

    Optional<Integer> getInt(String key);

    Optional<Boolean> getBoolean(String key);

    Optional<Float> getFloat(String key);

    Optional<Long> getLong(String key);

    Optional<Double> getDouble(String key);

    Optional<String[]> getStringArray(String key);

    <T extends Enum<?>> Optional<T > getEnum(String key, Class<T> enumType);

    <T> Optional<T> getObject(String key, Class<T> type);

    default String getOrDefault(String key, String def) { return get(key).orElse(def); }

    default int getIntOrDefault(String key, int def) { return getInt(key).orElse(def); }

    default boolean getBooleanOrDefault(String key, boolean def) { return getBoolean(key).orElse(def); }

    default float getFloatOrDefault(String key, float def) { return getFloat(key).orElse(def); }

    default long getLongOrDefault(String key, long def) { return getLong(key).orElse(def); }

    default double getDoubleOrDefault(String key, double def) { return getDouble(key).orElse(def); }

    default String[] getStringArrayOrDefault(String key, String[] def) { return getStringArray(key).orElse(def); }

    default <T extends Enum<?>> T getEnumOrDefault(String key, Class<T> enumType, T def) { return getEnum(key, enumType).orElse(def); }

    default <T> T getObjectOrDefault(String key, Class<T> type, T def) { return getObject(key, type).orElse(def); }
}
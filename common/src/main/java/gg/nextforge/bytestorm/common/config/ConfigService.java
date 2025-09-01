package gg.nextforge.bytestorm.common.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.ObjectInputFilter;

@RequiredArgsConstructor
public class ConfigService {

    private final ConfigSource source;

    public String get(@NonNull String key) {
        return source.get(key).orElseThrow(() -> new IllegalStateException("Missing config: " + key));
    }

    public Integer getInt(@NonNull String key) {
        return source.getInt(key).orElseThrow(() -> new IllegalStateException("Missing config: " + key));
    }

    public Boolean getBoolean(@NonNull String key) {
        return source.getBoolean(key).orElseThrow(() -> new IllegalStateException("Missing config: " + key));
    }

    public Float getFloat(@NonNull String key) {
        return source.getFloat(key).orElseThrow(() -> new IllegalStateException("Missing config: " + key));
    }

    public Long getLong(@NonNull String key) {
        return source.getLong(key).orElseThrow(() -> new IllegalStateException("Missing config: " + key));
    }

    public Double getDouble(@NonNull String key) {
        return source.getDouble(key).orElseThrow(() -> new IllegalStateException("Missing config: " + key));
    }

    public String[] getStringArray(@NonNull String key) {
        return source.getStringArray(key).orElseThrow(() -> new IllegalStateException("Missing config: " + key));
    }

    public <T> T getEnum(@NonNull String key, @NonNull Class<T> enumType) {
        return source.getEnum(key, enumType).orElseThrow(() -> new IllegalStateException("Missing config: " + key));
    }

    public <T> T getObject(@NonNull String key, @NonNull Class<T> type) {
        return source.getObject(key, type).orElseThrow(() -> new IllegalStateException("Missing config: " + key));
    }

    public String getOrDefault(@NonNull String key, @NonNull String def) { return source.getOrDefault(key, def); }

    public int getIntOrDefault(@NonNull String key, int def) { return source.getIntOrDefault(key, def); }

    public boolean getBooleanOrDefault(@NonNull String key, boolean def) { return source.getBooleanOrDefault(key, def); }

    public float getFloatOrDefault(@NonNull String key, float def) { return source.getFloatOrDefault(key, def); }

    public long getLongOrDefault(@NonNull String key, long def) { return source.getLongOrDefault(key, def); }

    public double getDoubleOrDefault(@NonNull String key, double def) { return source.getDoubleOrDefault(key, def); }

    public String[] getStringArrayOrDefault(@NonNull String key, @NonNull String[] def) { return source.getStringArrayOrDefault(key, def); }

    public <T> T getEnumOrDefault(@NonNull String key, @NonNull Class<T> enumType, @NonNull T def) { return source.getEnumOrDefault(key, enumType, def); }

    public <T> T getObjectOrDefault(@NonNull String key, @NonNull Class<T> type, @NonNull T def) { return source.getObjectOrDefault(key, type, def); }

}

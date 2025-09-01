package gg.nextforge.bytestorm.common.util;

import lombok.experimental.UtilityClass;

import java.time.Duration;

@UtilityClass
public class TimeUtils {
    public String human(Duration d) {
        long s = d.toSeconds();
        long h = s / 3600;
        s %= 3600;
        long m = s / 60;
        s %= 60;
        return String.format("%dh %dm %ds", h, m, s);
    }
}
package gg.nextforge.bytestorm.common.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public final class Messages {
    private final ResourceBundle bundle;

    public Messages(Locale locale) {
        this.bundle = ResourceBundle.getBundle("messages", locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
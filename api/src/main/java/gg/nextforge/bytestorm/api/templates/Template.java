package gg.nextforge.bytestorm.api.templates;

public interface Template {
    TemplateId id();
    String name();
    String path();
    TemplateVersion version();
}

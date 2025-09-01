package gg.nextforge.bytestorm.api.templates;

public interface Template {
    TemplateId id();
    String path();
    TemplateVersion version();
}

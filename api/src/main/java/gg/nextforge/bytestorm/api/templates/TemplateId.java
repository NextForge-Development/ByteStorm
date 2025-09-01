package gg.nextforge.bytestorm.api.templates;

public record TemplateId(String value) { public static TemplateId of(String v){ return new TemplateId(v); } }

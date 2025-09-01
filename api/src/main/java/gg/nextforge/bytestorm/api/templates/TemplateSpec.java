package gg.nextforge.bytestorm.api.templates;

import java.util.Map;

public record TemplateSpec(String runtime, Map<String, String> env) {}

package gg.nextforge.bytestorm.core.services;

import gg.nextforge.bytestorm.api.templates.Template;
import gg.nextforge.bytestorm.api.templates.TemplateId;
import gg.nextforge.bytestorm.api.templates.TemplateService;
import lombok.NonNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class TemplateServiceImpl implements TemplateService {
    private Map<String, Template> templates;

    public Template add(Template template) {
        return templates.put(template.name(), template);
    }

    @Override
    public Optional<Template> byId(@NonNull TemplateId id) {
        return Optional.ofNullable(templates.get(id.value()));
    }

    @Override
    public Optional<Template> byName(@NonNull String name) {
        return Optional.ofNullable(templates.get(name));
    }

    @Override
    public Collection<Template> all() {
        return Collections.unmodifiableCollection(templates.values());
    }

    @Override
    public void start() throws Exception {
        this.templates = new ConcurrentHashMap<>();
    }

    @Override
    public void stop() throws Exception {
        this.templates.clear();
    }
}

package gg.nextforge.bytestorm.api.templates;

import gg.nextforge.bytestorm.api.events.ByteStormEvent;

public sealed interface TemplateEvent extends ByteStormEvent permits TemplateEvent.Added, TemplateEvent.Removed, TemplateEvent.Updated {
    record Added(TemplateId id) implements TemplateEvent {}
    record Removed(TemplateId id) implements TemplateEvent {}
    record Updated(TemplateId id) implements TemplateEvent {}
}

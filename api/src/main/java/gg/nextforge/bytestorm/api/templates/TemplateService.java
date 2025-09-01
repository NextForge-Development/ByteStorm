package gg.nextforge.bytestorm.api.templates;

import lombok.NonNull;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TemplateService {
    Optional<Template> byId(@NonNull TemplateId id);
    Optional<Template> byName(@NonNull String name);
    Collection<Template> all();

    default CompletableFuture<Optional<Template>> asyncById(TemplateId id) {
        return CompletableFuture.supplyAsync(() -> byId(id));
    }

    default CompletableFuture<Optional<Template>> asyncByName(String name) {
        return CompletableFuture.supplyAsync(() -> byName(name));
    }

    default CompletableFuture<Collection<Template>> asyncAll() {
        return CompletableFuture.supplyAsync(this::all);
    }
}

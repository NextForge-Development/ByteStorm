package gg.nextforge.bytestorm.api.servers;

import gg.nextforge.bytestorm.api.services.Service;
import lombok.NonNull;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ServerService extends Service {
    Optional<CloudServer> byId(@NonNull ServerId id);
    Optional<CloudServer> byName(@NonNull String name);
    Optional<List<CloudServer>> byGroup(@NonNull String group);
    Optional<List<CloudServer>> byType(@NonNull ServerType type);
    Collection<CloudServer> all();

    default CompletableFuture<Optional<CloudServer>> asyncById(@NonNull ServerId id) {
        return CompletableFuture.supplyAsync(() -> byId(id));
    }

    default CompletableFuture<Optional<CloudServer>> asyncByName(@NonNull String name) {
        return CompletableFuture.supplyAsync(() -> byName(name));
    }

    default CompletableFuture<Optional<List<CloudServer>>> asyncByGroup(@NonNull String group) {
        return CompletableFuture.supplyAsync(() -> byGroup(group));
    }

    default CompletableFuture<Optional<List<CloudServer>>> asyncByType(@NonNull ServerType type) {
        return CompletableFuture.supplyAsync(() -> byType(type));
    }

    default CompletableFuture<Collection<CloudServer>> asyncAll() {
        return CompletableFuture.supplyAsync(this::all);
    }
}

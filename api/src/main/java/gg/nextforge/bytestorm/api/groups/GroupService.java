package gg.nextforge.bytestorm.api.groups;

import lombok.NonNull;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface GroupService {
    Optional<ServerGroup> byId(@NonNull GroupId id);
    Optional<ServerGroup> byName(@NonNull String name);
    Optional<List<ServerGroup>> byType(@NonNull GroupType type);
    Collection<ServerGroup> all();

    default CompletableFuture<Optional<ServerGroup>> asyncById(@NonNull GroupId id){
        return CompletableFuture.supplyAsync(() -> byId(id));
    }

    default CompletableFuture<Optional<ServerGroup>> asyncByName(@NonNull String name){
        return CompletableFuture.supplyAsync(() -> byName(name));
    }

    default CompletableFuture<Optional<List<ServerGroup>>> asyncByType(@NonNull GroupType type){
        return CompletableFuture.supplyAsync(() -> byType(type));
    }

    default CompletableFuture<Collection<ServerGroup>> asyncAll(){
        return CompletableFuture.supplyAsync(this::all);
    }
}

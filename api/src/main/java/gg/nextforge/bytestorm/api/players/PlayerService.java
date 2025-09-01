package gg.nextforge.bytestorm.api.players;

import lombok.NonNull;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PlayerService {
    Optional<CloudPlayer> byId(@NonNull PlayerId id);
    default Optional<CloudPlayer> byUniqueId(@NonNull UUID id){ return byId(new PlayerId(id)); }
    Optional<CloudPlayer> byName(@NonNull String name);
    Collection<CloudPlayer> all();

    default CompletableFuture<Optional<CloudPlayer>> asyncById(@NonNull PlayerId id){
        return CompletableFuture.supplyAsync(() -> byId(id));
    }

    default CompletableFuture<Optional<CloudPlayer>> asyncByUniqueId(@NonNull UUID id){
        return asyncById(new PlayerId(id));
    }

    default CompletableFuture<Optional<CloudPlayer>> asyncByName(@NonNull String name){
        return CompletableFuture.supplyAsync(() -> byName(name));
    }

    default CompletableFuture<Collection<CloudPlayer>> asyncAll(){
        return CompletableFuture.supplyAsync(this::all);
    }
}

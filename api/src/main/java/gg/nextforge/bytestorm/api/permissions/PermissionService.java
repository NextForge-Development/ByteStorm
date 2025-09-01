package gg.nextforge.bytestorm.api.permissions;

import lombok.NonNull;

import java.util.concurrent.CompletableFuture;

public interface PermissionService {
    Tristate check(@NonNull PermissionQuery query);

    default CompletableFuture<Tristate> asyncCheck(@NonNull PermissionQuery query) {
        return CompletableFuture.supplyAsync(() -> check(query));
    }
}

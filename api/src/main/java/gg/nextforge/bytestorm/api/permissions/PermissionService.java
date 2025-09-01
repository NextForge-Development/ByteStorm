package gg.nextforge.bytestorm.api.permissions;

import gg.nextforge.bytestorm.api.services.Service;
import lombok.NonNull;

import java.util.concurrent.CompletableFuture;

public interface PermissionService extends Service {
    Tristate check(@NonNull PermissionQuery query);

    default CompletableFuture<Tristate> asyncCheck(@NonNull PermissionQuery query) {
        return CompletableFuture.supplyAsync(() -> check(query));
    }
}

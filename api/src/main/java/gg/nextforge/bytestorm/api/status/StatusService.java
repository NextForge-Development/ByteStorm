package gg.nextforge.bytestorm.api.status;

import java.util.concurrent.CompletableFuture;

public interface StatusService {
    CloudStatus cloud();

    default CompletableFuture<CloudStatus> asyncCloud() {
        return CompletableFuture.supplyAsync(this::cloud);
    }
}

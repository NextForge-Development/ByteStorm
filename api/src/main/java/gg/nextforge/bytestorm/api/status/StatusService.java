package gg.nextforge.bytestorm.api.status;

import gg.nextforge.bytestorm.api.services.Service;

import java.util.concurrent.CompletableFuture;

public interface StatusService extends Service {
    CloudStatus cloud();

    default CompletableFuture<CloudStatus> asyncCloud() {
        return CompletableFuture.supplyAsync(this::cloud);
    }
}

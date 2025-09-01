package gg.nextforge.bytestorm.core.lifecycle;

import gg.nextforge.bytestorm.common.config.ConfigService;
import gg.nextforge.bytestorm.common.logging.LogFactory;
import gg.nextforge.bytestorm.core.services.ServiceRegistry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public final class LifecycleManager {
    private static final Logger log = LogFactory.get(LifecycleManager.class);

    private final ServiceRegistry services;
    private final ConfigService config;

    public void start() {
        log.info("== ByteStorm Core starting ==");
        services.startAll();
        log.info("Core started. Mode={} Threads={}", config.getOrDefault("BYTESTORM_MODE", "dev"), Thread.activeCount());
    }

    public void stop() {
        log.info("== ByteStorm Core stopping ==");
        services.stopAll();
        log.info("Core stopped.");
    }
}
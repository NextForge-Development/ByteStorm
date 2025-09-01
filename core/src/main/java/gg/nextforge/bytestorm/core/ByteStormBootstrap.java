package gg.nextforge.bytestorm.core;

import gg.nextforge.bytestorm.common.config.*;
import gg.nextforge.bytestorm.common.config.sources.impl.CompositeConfigSource;
import gg.nextforge.bytestorm.common.config.sources.impl.EnvConfigSource;
import gg.nextforge.bytestorm.common.config.sources.impl.SystemPropertyConfigSource;
import gg.nextforge.bytestorm.core.lifecycle.LifecycleManager;
import gg.nextforge.bytestorm.api.services.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public final class ByteStormBootstrap {
    private static final Logger log = LoggerFactory.getLogger(ByteStormBootstrap.class);

    public static void main(String[] args) {
        ConfigService config = new ConfigService(new CompositeConfigSource(List.of(
                new SystemPropertyConfigSource(), new EnvConfigSource()
        )));

        var registry = new ServiceRegistry();
        var lifecycle = new LifecycleManager(registry, config);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try { lifecycle.stop(); } catch (Exception e) { log.error("Shutdown error", e); }
        }, "bytestorm-shutdown"));

        lifecycle.start();
    }
}
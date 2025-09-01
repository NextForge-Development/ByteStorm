package gg.nextforge.bytestorm.core.services;

import gg.nextforge.bytestorm.common.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public final class ServiceRegistry {
    private static final Logger log = LogFactory.get(ServiceRegistry.class);

    private final List<Service> services = new ArrayList<>();

    public ServiceRegistry register(Service service) {
        services.add(service);
        return this;
    }

    public void startAll() {
        for (Service s : services) {
            try { s.start(); log.info("Service started: {}", s.name()); }
            catch (Exception e) { throw new RuntimeException("Failed to start service: " + s.name(), e); }
        }
    }

    public void stopAll() {
        for (int i = services.size() - 1; i >= 0; i--) {
            Service s = services.get(i);
            try { s.stop(); log.info("Service stopped: {}", s.name()); }
            catch (Exception e) { log.error("Failed to stop service: {}", s.name(), e); }
        }
    }
}
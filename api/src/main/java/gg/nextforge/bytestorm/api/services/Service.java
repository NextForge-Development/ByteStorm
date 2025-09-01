package gg.nextforge.bytestorm.api.services;

import gg.nextforge.bytestorm.common.logging.LogFactory;
import org.slf4j.Logger;

public interface Service {
    void start() throws Exception;
    void stop() throws Exception;
    default String name() { return getClass().getSimpleName(); }
    default Logger log() { return LogFactory.get(getClass()); }
}
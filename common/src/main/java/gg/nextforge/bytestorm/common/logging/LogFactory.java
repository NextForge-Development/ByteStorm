package gg.nextforge.bytestorm.common.logging;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;

@UtilityClass
public class LogFactory {

    public Logger get(Class<?> type) {
        return org.slf4j.LoggerFactory.getLogger(type);
    }
}
package gg.nextforge.bytestorm.api.events;

import lombok.NonNull;

import java.util.function.Consumer;

/**
 * API-facing event bus (core provides the implementation).
 * @see EventPriority
 * @see Subscription
 * @see ByteStormEvent
 * @see EventContext
 */
public interface EventBus {
    <T extends ByteStormEvent> Subscription subscribe(@NonNull Class<T> type,
                                                      @NonNull EventPriority priority,
                                                      @NonNull Consumer<T> listener);

    default <T extends ByteStormEvent> Subscription subscribe(@NonNull Class<T> type, @NonNull Consumer<T> l) {
        return subscribe(type, EventPriority.NORMAL, l);
    }

    void publish(@NonNull ByteStormEvent event, EventContext context);
}

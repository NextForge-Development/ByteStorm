package gg.nextforge.bytestorm.api.events;

/** Disposable handle for an event subscription. */
public interface Subscription extends AutoCloseable {
    @Override void close();
}

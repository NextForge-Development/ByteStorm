package gg.nextforge.bytestorm.api.events;

public interface Cancellable {
    boolean isCancelled();

    void setCancelled(boolean cancelled);
}

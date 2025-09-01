package gg.nextforge.bytestorm.api.events;

import java.time.Instant;

/**
 * EventContext holds metadata about an event, such as the node ID where it originated,
 * the timestamp of when it was created, and its origin.
 * @param nodeId the ID of the node where the event originated, e.g., "node-123", "local-node"
 * @param timestamp the time when the event was created
 * @param origin the origin of the event, e.g., "user-action", "system-event"
 */
public record EventContext(String nodeId, Instant timestamp, String origin) {}

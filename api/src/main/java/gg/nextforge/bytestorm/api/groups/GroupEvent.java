package gg.nextforge.bytestorm.api.groups;

import gg.nextforge.bytestorm.api.events.ByteStormEvent;

public sealed interface GroupEvent extends ByteStormEvent permits GroupEvent.Created, GroupEvent.Updated, GroupEvent.Deleted {
    record Created(GroupId id) implements GroupEvent {}
    record Updated(GroupId id) implements GroupEvent {}
    record Deleted(GroupId id) implements GroupEvent {}
}

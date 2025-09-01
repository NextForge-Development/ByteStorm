package gg.nextforge.bytestorm.api.query;

import gg.nextforge.bytestorm.api.players.CloudPlayer;
import gg.nextforge.bytestorm.api.servers.CloudServer;
import gg.nextforge.bytestorm.api.groups.ServerGroup;

import java.util.concurrent.CompletableFuture;

public interface QueryService {
    QueryResult<CloudPlayer> players(QuerySpec spec);
    QueryResult<CloudServer> servers(QuerySpec spec);
    QueryResult<ServerGroup> groups(QuerySpec spec);

    default CompletableFuture<QueryResult<CloudPlayer>> asyncPlayers(QuerySpec spec) {
        return CompletableFuture.supplyAsync(() -> players(spec));
    }

    default CompletableFuture<QueryResult<CloudServer>> asyncServers(QuerySpec spec) {
        return CompletableFuture.supplyAsync(() -> servers(spec));
    }

    default CompletableFuture<QueryResult<ServerGroup>> asyncGroups(QuerySpec spec) {
        return CompletableFuture.supplyAsync(() -> groups(spec));
    }
}

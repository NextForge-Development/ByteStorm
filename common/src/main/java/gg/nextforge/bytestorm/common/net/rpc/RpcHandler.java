package gg.nextforge.bytestorm.common.net.rpc;

@FunctionalInterface public interface RpcHandler { byte[] handle(String method, byte[] payload) throws Exception; }

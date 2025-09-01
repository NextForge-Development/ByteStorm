package gg.nextforge.bytestorm.common.net.rpc;

public interface RpcClient { byte[] call(String service, String method, byte[] payload) throws Exception; }
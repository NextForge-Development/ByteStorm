package gg.nextforge.bytestorm.common.net.rpc;

public interface RpcServer {
    void register(String service, RpcHandler handler);
}

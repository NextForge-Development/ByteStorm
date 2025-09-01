package gg.nextforge.bytestorm.common.net.http;

public record HttpRequest(String method, String path, byte[] body) {}
package gg.nextforge.bytestorm.common.net.http;

public record HttpResponse(int status, byte[] body) {}
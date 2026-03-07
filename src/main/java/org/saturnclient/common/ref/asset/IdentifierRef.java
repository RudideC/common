package org.saturnclient.common.ref.asset;

public interface IdentifierRef {
    public static IdentifierRef of(String namespace, String path) {
        return null;
    }

    public static IdentifierRef of(String fullPath) {
        return null;
    }

    public static IdentifierRef ofSaturn(String path) {
        return null;
    }

    public static IdentifierRef ofVanilla(String path) {
        return null;
    }

    @Override
    public String toString();
}

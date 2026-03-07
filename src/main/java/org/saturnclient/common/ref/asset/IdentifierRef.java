package org.saturnclient.common.ref.asset;

import org.saturnclient.common.provider.Providers;

public interface IdentifierRef {
    public static IdentifierRef of(String namespace, String path) {
        return Providers.refConstructor.identifier(namespace, path);
    }

    public static IdentifierRef of(String fullPath) {
        return Providers.refConstructor.identifier(fullPath);
    }

    public static IdentifierRef ofSaturn(String path) {
        return of("saturnclient", path);
    }

    public static IdentifierRef ofVanilla(String path) {
        return of("minecraft", path);
    }

    @Override
    public String toString();
}

package org.saturnclient.common.provider;

import org.saturnclient.common.ref.asset.IdentifierRef;

public interface RefConstructorProvider {
    public abstract IdentifierRef identifier(String namespace, String path);
    public abstract IdentifierRef identifier(String fullPath);
}

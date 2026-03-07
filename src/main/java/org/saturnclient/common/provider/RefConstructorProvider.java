package org.saturnclient.common.provider;

import org.saturnclient.common.ref.asset.IdentifierRef;

public abstract class RefConstructorProvider {
    public abstract IdentifierRef identifier(String namespace, String path);
    public abstract IdentifierRef identifier(String fullPath);
}

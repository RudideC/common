package org.saturnclient.common.provider;

import org.saturnclient.common.ref.asset.IdentifierRef;
import org.saturnclient.common.ref.render.TextRef;

public interface RefConstructorProvider {
    public abstract IdentifierRef identifier(String namespace, String path);

    public abstract IdentifierRef identifier(String fullPath);

    public abstract TextRef text(String text);
}

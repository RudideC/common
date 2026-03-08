package org.saturnclient.common.provider;

import org.saturnclient.common.ref.asset.IdentifierRef;
import org.saturnclient.common.ref.render.TextRef;

public interface RefConstructorProvider {
    public IdentifierRef identifier(String namespace, String path);

    public IdentifierRef identifier(String fullPath);

    public TextRef text(String text);
}

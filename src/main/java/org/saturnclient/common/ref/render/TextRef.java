package org.saturnclient.common.ref.render;

import org.saturnclient.common.provider.Providers;
import org.saturnclient.common.ref.asset.IdentifierRef;

public interface TextRef {
    public TextRef withFont(IdentifierRef font);

    public int getWidth();

    public static TextRef literal(String text) {
        return Providers.refConstructor.text(text);
    }
}

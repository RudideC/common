package org.saturnclient.common.ref.asset;

import org.saturnclient.common.MinecraftBinding;
import org.saturnclient.common.MinecraftProvider;

public class IdentifierRef extends MinecraftBinding {
    public IdentifierRef(String namespace, String path) {
        super(MinecraftProvider.PROVIDER.createIdentifier(namespace, path));
    }

    public IdentifierRef(Object o) {
        super(o);
    }

    public static IdentifierRef of(String namespace, String path) {
        return new IdentifierRef(namespace, path);
    }

    public static IdentifierRef of(String fullPath) {
        String[] p = fullPath.split(":", 2);

        return new IdentifierRef(p[0], p[1]);
    }

    public static IdentifierRef ofVanilla(String path) {
        return new IdentifierRef("minecraft", path);
    }

    @Override
    public String toString() {
        return this.inner.toString();
    }
}

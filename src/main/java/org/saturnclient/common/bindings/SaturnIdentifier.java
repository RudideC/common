package org.saturnclient.common.bindings;

import org.saturnclient.common.MinecraftBinding;
import org.saturnclient.common.MinecraftProvider;

public class SaturnIdentifier extends MinecraftBinding {
    public SaturnIdentifier(String namespace, String path) {
        super(MinecraftProvider.PROVIDER.createIdentifier(namespace, path));
    }

    public SaturnIdentifier(Object o) {
        super(o);
    }

    public static SaturnIdentifier of(String namespace, String path) {
        return new SaturnIdentifier(namespace, path);
    }

    public static SaturnIdentifier of(String fullPath) {
        String[] p = fullPath.split(":", 2);

        return new SaturnIdentifier(p[0], p[1]);
    }

    public static SaturnIdentifier ofVanilla(String path) {
        return new SaturnIdentifier("minecraft", path);
    }

    @Override
    public String toString() {
        return this.inner.toString();
    }
}

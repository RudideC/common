package org.saturnclient.common.provider;

import org.saturnclient.common.ref.asset.IdentifierRef;
import org.saturnclient.common.ref.game.MinecraftClientRef;

import java.awt.image.BufferedImage;

public interface SaturnProvider {
    public abstract MinecraftClientRef getClient();

    public abstract boolean isKeyPressed(int key);

    public abstract int getWidth(String text, int font);

    public abstract void registerBufferedImageTexture(IdentifierRef i, BufferedImage bi);

    public abstract String getKeyName(int key);

    public abstract void stop();
}

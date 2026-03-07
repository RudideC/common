package org.saturnclient.common.ref.game;

import java.io.File;
import java.io.InputStream;

import org.saturnclient.common.ref.asset.IdentifierRef;
import org.saturnclient.common.ref.render.WindowRef;
import org.saturnclient.ui.SaturnScreen;

public interface MinecraftClientRef {
    public static enum MinecraftScreen {
        SelectWorld,
        Multiplayer,
        Options
    }

    public File getRunDirectory();

    public InputStream getResource(IdentifierRef identifier);

    public WindowRef getWindow();

    public void setScreen(SaturnScreen screen);

    public void setScreen(MinecraftScreen screen);
}

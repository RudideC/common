package org.saturnclient.common.ref.game;

import java.io.File;
import java.io.InputStream;

import org.saturnclient.common.ref.asset.IdentifierRef;
import org.saturnclient.common.ref.render.WindowRef;

public interface MinecraftClientRef {

    public File getRunDirectory();

    public InputStream getResource(IdentifierRef identifier);

    public WindowRef getWindow();
}

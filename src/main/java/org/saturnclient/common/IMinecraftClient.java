package org.saturnclient.common;

import java.io.File;
import java.io.InputStream;

import org.saturnclient.common.bindings.SaturnIdentifier;
import org.saturnclient.common.render.IWindow;

public interface IMinecraftClient {

    public File getRunDirectory();

    public InputStream getResource(SaturnIdentifier identifier);

    public IWindow getWindow();
}

package org.saturnclient.mod;

import org.saturnclient.ui.RenderScope;

public interface HudMod {
    public ModLayout getDimensions();

    public void renderDummy(RenderScope scope);

    public void renderHud(RenderScope scope);
}

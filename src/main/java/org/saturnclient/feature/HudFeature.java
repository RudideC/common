package org.saturnclient.feature;

import org.saturnclient.ui.RenderScope;

public interface HudFeature {
    public FeatureLayout getDimensions();

    public void renderDummy(RenderScope scope);

    public void renderHud(RenderScope scope);
}

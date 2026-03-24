package org.saturnclient.ui.components;

import org.saturnclient.mod.HudMod;
import org.saturnclient.mod.ModLayout;
import org.saturnclient.ui.Element;
import org.saturnclient.ui.ElementContext;
import org.saturnclient.ui.RenderScope;

public class HudModPreview extends Element {
    HudMod feature;

    public HudModPreview(HudMod feature) {
        this.feature = feature;
    }

    @Override
    public void render(RenderScope scope, ElementContext ctx) {
        ModLayout layout = feature.getDimensions();

        if (layout.renderBackground) {
            scope.drawRoundedRectangle(0, 0, layout.width, layout.height,
                    layout.radius.value, layout.bgColor.value);
        }

        feature.renderDummy(scope);
    }
}

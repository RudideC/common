package org.saturnclient.feature.features;

import org.saturnclient.config.manager.Property;
import org.saturnclient.feature.HudFeature;
import org.saturnclient.feature.FeatureLayout;
import org.saturnclient.feature.Feature;
import org.saturnclient.feature.FeatureDetails;
import org.saturnclient.feature.interfaces.FpsInterface;
import org.saturnclient.ui.RenderScope;
import org.saturnclient.ui.resources.Fonts;

public class Fps extends Feature implements HudFeature {

    private static Property<Boolean> enabled = Property.bool(false);
    private static FeatureLayout dimensions = new FeatureLayout(60, Fonts.getHeight());

    private final FpsInterface minecraft;

    public Fps(FpsInterface minecraft) {
        super(new FeatureDetails("FPS Display", "fps")
                .description("Displays current FPS")
                .version("v0.1.0")
                .tags("Utility"),
                enabled.named("Enabled"),
                dimensions.prop());

        this.minecraft = minecraft;
    }

    @Override
    public void renderHud(RenderScope scope) {
        int fps = minecraft.getFps();

        String text = fps + " FPS";

        scope.drawText(text, 0, 0, dimensions.font.value, dimensions.fgColor.value);

        dimensions.width = Fonts.getWidth(text, dimensions.font.value);
    }

    @Override
    public void renderDummy(RenderScope scope) {
        String text = "369 FPS";

        scope.drawText(text, 0, 0, dimensions.font.value, dimensions.fgColor.value);

        dimensions.width = Fonts.getWidth(text, dimensions.font.value);
    }

    @Override
    public boolean isEnabled() {
        return enabled.value;
    }

    @Override
    public void onEnabled(boolean e) {
        enabled.value = e;
    }

    @Override
    public FeatureLayout getDimensions() {
        return dimensions;
    }
}
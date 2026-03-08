package org.saturnclient.feature.features;

import org.saturnclient.config.manager.Property;
import org.saturnclient.feature.HudFeature;
import org.saturnclient.feature.FeatureLayout;
import org.saturnclient.feature.Feature;
import org.saturnclient.feature.FeatureDetails;
import org.saturnclient.feature.interfaces.PingInterface;
import org.saturnclient.ui.RenderScope;
import org.saturnclient.ui.resources.Fonts;

public class Ping extends Feature implements HudFeature {

    private static Property<Boolean> enabled = Property.bool(false);
    private static FeatureLayout dimensions = new FeatureLayout(60, Fonts.getHeight());

    private final PingInterface pingProvider;

    public Ping(PingInterface pingProvider) {
        super(new FeatureDetails("Ping Display", "ping")
                .description("Displays ping")
                .version("v0.1.0")
                .tags("Utility"),
                enabled.named("Enabled"),
                dimensions.prop());

        this.pingProvider = pingProvider;
    }

    @Override
    public void renderHud(RenderScope scope) {
        int ping = pingProvider.getPing();
        String text = ping + " ms";
        scope.drawText(text, 0, 0, dimensions.font.value, dimensions.fgColor.value);
        dimensions.width = Fonts.getWidth(text, dimensions.font.value);
    }

    @Override
    public void renderDummy(RenderScope scope) {
        String text = "10 ms";
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
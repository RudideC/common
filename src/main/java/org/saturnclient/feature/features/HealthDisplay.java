package org.saturnclient.feature.features;

import org.saturnclient.config.manager.Property;
import org.saturnclient.feature.HudFeature;
import org.saturnclient.feature.FeatureLayout;
import org.saturnclient.feature.Feature;
import org.saturnclient.feature.FeatureDetails;
import org.saturnclient.feature.interfaces.HealthDisplayInterface;
import org.saturnclient.ui.RenderScope;
import org.saturnclient.ui.resources.Fonts;

public class HealthDisplay extends Feature implements HudFeature {

    private static Property<Boolean> enabled = Property.bool(false);
    private static Property<Integer> displayMode = Property.select(0, "Health", "Hearts");
    private static Property<Integer> decimals = Property.select(0, "0", "1", "2");

    private static FeatureLayout dimensions = new FeatureLayout(40, 18);

    private final HealthDisplayInterface minecraft;

    public HealthDisplay(HealthDisplayInterface minecraft) {
        super(new FeatureDetails("Health display", "health")
                .description("Displays your current health")
                .version("v0.1.0")
                .tags("Utility"),
                enabled.named("Enabled"),
                displayMode.named("Display mode"),
                decimals.named("Decimals"),
                dimensions.prop());

        this.minecraft = minecraft;
    }

    @Override
    public void renderDummy(RenderScope scope) {
        renderHealth(10, scope);
    }

    @Override
    public void renderHud(RenderScope scope) {
        float health = minecraft.getPlayerHealth();

        switch (displayMode.value) {
            case 1:
                health = health / 2;
                break;
        }

        renderHealth(health, scope);
    }

    public void renderHealth(float health, RenderScope scope) {

        String text = "";

        switch (decimals.value) {
            case 0:
                text = String.format("%.0f ", health);
                break;

            case 1:
                text = String.format("%.1f ", health);
                break;

            case 2:
                text = String.format("%.2f ", health);
                break;
        }

        scope.drawText(
                text,
                0,
                0,
                dimensions.font.value,
                dimensions.fgColor.value);

        dimensions.width = Fonts.getWidth(text, dimensions.font.value);
        dimensions.height = 18 * text.split("\n").length;
    }

    @Override
    public boolean isEnabled() {
        return enabled.value;
    }

    @Override
    public FeatureLayout getDimensions() {
        return dimensions;
    }

    @Override
    public void onEnabled(boolean e) {
        enabled.value = e;
    }
}
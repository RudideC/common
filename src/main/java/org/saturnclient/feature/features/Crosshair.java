package org.saturnclient.feature.features;

import org.saturnclient.config.manager.Property;
import org.saturnclient.feature.Feature;
import org.saturnclient.feature.FeatureDetails;
import org.saturnclient.feature.interfaces.CrosshairInterface;
import org.saturnclient.ui.RenderScope;
import org.saturnclient.ui.resources.Textures;

public class Crosshair extends Feature {

    public static Property<Boolean> enabled = Property.bool(false);

    private final CrosshairInterface minecraft;

    public Crosshair(CrosshairInterface minecraft) {
        super(
                new FeatureDetails("Crosshair", "crosshair")
                        .description("Changes the crosshair if you're aiming at a entity")
                        .tags("Visuals", "Utility")
                        .version("v0.1.0"),
                enabled.named("Enabled"));

        this.minecraft = minecraft;
    }

    @Override
    public void render(RenderScope scope) {

        if (enabled.value && minecraft.isTargetingLivingEntity()) {

            int scaledWidth = 15;
            int scaledHeight = 15;

            scope.drawTexture(
                    Textures.CROSSHAIR_RANGE,
                    (scope.getScaledWindowWidth() - scaledWidth) / 2,
                    (scope.getScaledWindowHeight() - scaledHeight) / 2,
                    0.0F,
                    0.0F,
                    scaledWidth,
                    scaledHeight);
        }
    }

    @Override
    public boolean isEnabled() {
        return enabled.value;
    }

    @Override
    public void onEnabled(boolean e) {
        enabled.value = e;
    }
}
package org.saturnclient.feature.features;

import org.saturnclient.config.manager.Property;
import org.saturnclient.feature.Feature;
import org.saturnclient.feature.FeatureDetails;
import org.saturnclient.feature.interfaces.AutoSprintInterface;

public class AutoSprint extends Feature {

    private static Property<Boolean> enabled = Property.bool(false);

    private final AutoSprintInterface minecraft;

    public AutoSprint(AutoSprintInterface minecraft) {
        super(
                new FeatureDetails("Auto Sprint", "sprint")
                        .description("Makes the player always sprint")
                        .tags("Movement")
                        .version("v0.1.0"),
                enabled.named("Enabled"));

        this.minecraft = minecraft;
    }

    @Override
    public void tick() {
        if (!minecraft.hasPlayer() || !minecraft.hasNetwork()) {
            return;
        }

        if (minecraft.isForwardPressed()
                && !minecraft.isBackPressed()
                && !minecraft.isSneaking()
                && !minecraft.hasHorizontalCollision()
                && !minecraft.isUsingItem()) {

            minecraft.setSprinting(true);
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
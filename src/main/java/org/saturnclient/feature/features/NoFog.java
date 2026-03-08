package org.saturnclient.feature.features;

import org.saturnclient.config.manager.Property;
import org.saturnclient.feature.Feature;
import org.saturnclient.feature.FeatureDetails;

public class NoFog extends Feature {
    private static Property<Boolean> enabled = Property.bool(false);
    private static Property<Boolean> liquids = Property.bool(false);

    public NoFog() {
        super(
                new FeatureDetails("No Fog", "nofog")
                        .description("Stops fog from rendering")
                        .tags("Camera")
                        .version("v0.1.0"),
                enabled.named("Enabled"),
                liquids.named("See through liquids"));
    }

    @Override
    public boolean isEnabled() {
        return enabled.value;
    }

    @Override
    public void onEnabled(boolean e) {
        enabled.value = e;
    }

    // static for the mixin
    public static boolean isActive() {
        return enabled.value;
    }

    public static boolean liquids() {
        return liquids.value;
    }
}

package org.saturnclient.feature.features;

import org.saturnclient.config.manager.Property;
import org.saturnclient.feature.Feature;
import org.saturnclient.feature.FeatureDetails;

public class Fullbright extends Feature {
    private static Property<Boolean> enabled = Property.bool(false);
    private static Property<Integer> brightness = Property.integer(100);

    public Fullbright() {
        super(
                new FeatureDetails("Fullbright", "fullbright")
                        .description("Allows you to see in the dark")
                        .tags("Camera")
                        .version("v0.1.0"),
                enabled.named("Enabled"),
                brightness.named("Brightness %"));
    }

    @Override
    public boolean isEnabled() {
        return enabled.value;
    }

    @Override
    public void onEnabled(boolean e) {
        enabled.value = e;
    }

    public static boolean shouldOverrideBrightness() {
        return enabled.value;
    }

    public static float getBrightnessValue() {
        return brightness.value / 10;
    }

}

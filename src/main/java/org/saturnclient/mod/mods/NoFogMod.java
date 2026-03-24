package org.saturnclient.mod.mods;

import org.saturnclient.config.property.BoolProperty;
import org.saturnclient.config.property.Property;
import org.saturnclient.mod.Mod;
import org.saturnclient.mod.ModSpec;

/**
 * NoFogMod suppresses distance fog and (optionally) liquid fog.
 *
 * Like {@link FullbrightMod}, the actual suppression is applied
 * inside a mixin. This class owns the configuration and provides
 * static query methods the mixin calls.
 */
public class NoFogMod extends Mod {

    private static final BoolProperty enabled = Property.bool(false);

    public NoFogMod() {
        super(
                new ModSpec("No Fog", "nofog")
                        .description("Stops fog from rendering")
                        .tags("Camera")
                        .version("v0.2.0"),
                enabled.named("Enabled"));
    }

    /** Returns {@code true} when fog should be suppressed. */
    public static boolean isActive() {
        return enabled.value;
    }

    // ---------------------------------------------------------------
    // Mod contract
    // ---------------------------------------------------------------

    @Override
    public boolean isEnabled() {
        return enabled.value;
    }

    @Override
    public void onEnabled(boolean e) {
        enabled.value = e;
    }
}

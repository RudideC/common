package org.saturnclient.mod.mods;

import org.saturnclient.common.module.RenderModule;
import org.saturnclient.common.provider.Providers;
import org.saturnclient.config.property.BoolProperty;
import org.saturnclient.config.property.Property;
import org.saturnclient.mod.HudMod;
import org.saturnclient.mod.Mod;
import org.saturnclient.mod.ModLayout;
import org.saturnclient.mod.ModSpec;
import org.saturnclient.ui.RenderScope;
import org.saturnclient.ui.resources.Fonts;

/**
 * FpsFeature displays the current frames-per-second as a HUD element.
 * FPS is obtained from {@link RenderModule} rather than cached in the feature.
 */
public class FpsFeature extends Mod implements HudMod {

    private static final BoolProperty enabled = Property.bool(false);
    private static final ModLayout layout = new ModLayout(60, Fonts.getHeight());

    public FpsFeature() {
        super(
                new ModSpec("FPS Display", "fps")
                        .description("Displays current FPS")
                        .version("v0.2.0")
                        .tags("Utility"),
                enabled.named("Enabled"),
                layout.prop());
    }

    // ---------------------------------------------------------------
    // HudFeature
    // ---------------------------------------------------------------

    @Override
    public void renderHud(RenderScope scope) {
        renderFps(Providers.module.render().getFps(), scope);
    }

    @Override
    public void renderDummy(RenderScope scope) {
        renderFps(369, scope);
    }

    // ---------------------------------------------------------------
    // Rendering
    // ---------------------------------------------------------------

    private void renderFps(int fps, RenderScope scope) {
        String text = fps + " FPS";
        scope.drawText(text, 0, 0, layout.font.value, layout.fgColor.value);
        layout.width = Fonts.getWidth(text, layout.font.value);
    }

    // ---------------------------------------------------------------
    // Feature contract
    // ---------------------------------------------------------------

    @Override
    public ModLayout getDimensions() {
        return layout;
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

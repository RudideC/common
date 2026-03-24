package org.saturnclient.mod.mods;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.saturnclient.ui.RenderScope;
import org.saturnclient.ui.resources.Fonts;
import org.saturnclient.config.property.BoolProperty;
import org.saturnclient.config.property.Property;
import org.saturnclient.config.property.SelectProperty;
import org.saturnclient.mod.HudMod;
import org.saturnclient.mod.Mod;
import org.saturnclient.mod.ModLayout;
import org.saturnclient.mod.ModSpec;

/**
 * ClockMod displays the real-world time as a HUD element.
 * No engine access is required; {@link LocalTime} is used directly.
 */
public class ClockMod extends Mod implements HudMod {

    private static final BoolProperty enabled = Property.bool(false);
    private static final SelectProperty format = Property.select(0, "24 hour", "12 hour");
    private static final BoolProperty showSeconds = Property.bool(false);
    private static final ModLayout layout = new ModLayout(60, Fonts.getHeight());

    public ClockMod() {
        super(
                new ModSpec("Clock", "clock")
                        .description("Displays the current real-world time")
                        .version("v0.2.0")
                        .tags("Utility"),
                enabled.named("Enabled"),
                format.named("Format"),
                showSeconds.named("Show seconds"),
                layout.prop());
    }

    // ---------------------------------------------------------------
    // HudMod
    // ---------------------------------------------------------------

    @Override
    public void renderHud(RenderScope scope) {
        renderClock(scope);
    }

    @Override
    public void renderDummy(RenderScope scope) {
        renderClock(scope);
    }

    // ---------------------------------------------------------------
    // Rendering
    // ---------------------------------------------------------------

    private void renderClock(RenderScope scope) {
        String text = buildTimeString(LocalTime.now());

        scope.drawText(text, 0, 0, layout.font.value, layout.fgColor.value);
        layout.width = Fonts.getWidth(text, layout.font.value);
        layout.height = 18 * text.split("\n").length;
    }

    private String buildTimeString(LocalTime time) {
        return switch (format.value) {
            case 1 -> time.format(showSeconds.value
                    ? DateTimeFormatter.ofPattern("hh:mm:ss a")
                    : DateTimeFormatter.ofPattern("hh:mm a"));
            default -> time.format(showSeconds.value
                    ? DateTimeFormatter.ofPattern("HH:mm:ss")
                    : DateTimeFormatter.ofPattern("HH:mm"));
        };
    }

    // ---------------------------------------------------------------
    // Mod contract
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

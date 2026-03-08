package org.saturnclient.feature.features;

import java.util.List;

import org.saturnclient.config.manager.Property;
import org.saturnclient.feature.HudFeature;
import org.saturnclient.feature.FeatureLayout;
import org.saturnclient.feature.Feature;
import org.saturnclient.feature.FeatureDetails;
import org.saturnclient.feature.interfaces.StatusEffectsInterface;
import org.saturnclient.ui.RenderScope;

public class StatusEffects extends Feature implements HudFeature {

    public static Property<Boolean> enabled = Property.bool(false);
    private static FeatureLayout dimensions = new FeatureLayout(60, 0);

    private final StatusEffectsInterface provider;

    public StatusEffects(StatusEffectsInterface provider) {
        super(new FeatureDetails("Status effects", "effect")
                .description("Displays status effects")
                .version("v0.1.0")
                .tags("Utility"),
                enabled.named("Enabled"),
                dimensions.prop());

        this.provider = provider;
    }

    private void renderEffects(RenderScope scope, List<StatusEffectsInterface.Effect> effects) {
        int row = 0;

        for (StatusEffectsInterface.Effect effect : effects) {
            if (!effect.shouldShowIcon())
                continue;

            scope.drawSpriteStretched(effect.getIcon(), 0, 18 * row, 16, 16);
            scope.drawText(0.5f, getDurationAsString(effect), 18, 18 * row + 3, dimensions.font.value, -1);
            row++;
        }

        dimensions.height = 18 * row;
    }

    @Override
    public void renderHud(RenderScope scope) {
        renderEffects(scope, provider.getActiveEffects());
    }

    @Override
    public void renderDummy(RenderScope scope) {
        renderEffects(scope, provider.getDummyEffects());
    }

    private String getDurationAsString(StatusEffectsInterface.Effect effect) {
        if (effect.isInfinite()) {
            return effect.getInfiniteText();
        }

        int totalSeconds = effect.getDurationSeconds();
        if (totalSeconds >= 3600) {
            return totalSeconds / 3600 + "h";
        } else if (totalSeconds >= 60) {
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;
            return String.format("%d:%02d", minutes, seconds);
        } else {
            return totalSeconds + "s";
        }
    }

    @Override
    public FeatureLayout getDimensions() {
        return dimensions;
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
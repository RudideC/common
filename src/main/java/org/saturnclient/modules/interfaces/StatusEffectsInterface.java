package org.saturnclient.modules.interfaces;

import java.util.List;

import org.saturnclient.common.ref.asset.SpriteRef;

public interface StatusEffectsInterface {

    /** Returns a list of currently active effects */
    List<Effect> getActiveEffects();

    /** Returns a dummy list of effects for dummy rendering */
    List<Effect> getDummyEffects();

    /** Represents a single effect for rendering purposes */
    class Effect {
        private final SpriteRef icon;
        private final int durationSeconds;
        private final boolean infinite;
        private final boolean showIcon;
        private final String infiniteText;

        public Effect(SpriteRef icon, int durationSeconds, boolean infinite, boolean showIcon, String infiniteText) {
            this.icon = icon;
            this.durationSeconds = durationSeconds;
            this.infinite = infinite;
            this.showIcon = showIcon;
            this.infiniteText = infiniteText;
        }

        public SpriteRef getIcon() {
            return icon;
        }

        public int getDurationSeconds() {
            return durationSeconds;
        }

        public boolean isInfinite() {
            return infinite;
        }

        public boolean shouldShowIcon() {
            return showIcon;
        }

        public String getInfiniteText() {
            return infiniteText;
        }
    }
}
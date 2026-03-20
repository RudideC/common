package org.saturnclient.common.ref.game;

import org.saturnclient.common.ref.asset.SpriteRef;

public interface EffectRef {
    boolean shouldShowIcon();

    SpriteRef getIcon();

    boolean isInfinite();

    String getInfiniteText();

    int getDurationSeconds();
}

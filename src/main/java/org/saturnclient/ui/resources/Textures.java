package org.saturnclient.ui.resources;

import org.saturnclient.common.ref.asset.IdentifierRef;

public class Textures {
    public static final IdentifierRef CROSSHAIR_RANGE = IdentifierRef
            .ofSaturn("textures/gui/hud/crosshair_range.png");
    public static final IdentifierRef COSMETICS = IdentifierRef.ofSaturn("textures/gui/components/cosmetics.png");
    public static final IdentifierRef HUD_ICON = IdentifierRef.ofSaturn("textures/gui/components/hud.png");
    public static final IdentifierRef SEARCH = IdentifierRef.ofSaturn("textures/gui/components/search.png");
    public static final IdentifierRef CLOSE = IdentifierRef.ofSaturn("textures/gui/components/close.png");
    public static final IdentifierRef MODS_TAB = IdentifierRef.ofSaturn("textures/gui/components/mods_tab.png");
    public static final IdentifierRef SETTINGS = IdentifierRef.ofSaturn("textures/gui/components/settings.png");
    public static final IdentifierRef CLOAK = IdentifierRef.ofSaturn("textures/gui/components/cloak.png");
    public static final IdentifierRef HAT = IdentifierRef.ofSaturn("textures/gui/components/hat.png");
    public static final IdentifierRef RESET = IdentifierRef.ofSaturn("textures/gui/components/reset.png");
    public static final IdentifierRef TOGGLE_INDICATOR = IdentifierRef
            .ofSaturn("textures/gui/components/toggle_indicator.png");
    public static final IdentifierRef LEFT = IdentifierRef.ofSaturn("textures/gui/components/left.png");
    public static final IdentifierRef RIGHT = IdentifierRef.ofSaturn("textures/gui/components/right.png");
    public static final IdentifierRef STORE = IdentifierRef.ofSaturn("textures/gui/components/store.png");
    public static final IdentifierRef COINS = IdentifierRef.ofSaturn("textures/gui/components/coins.png");
    public static final IdentifierRef SHIRT = IdentifierRef.ofSaturn("textures/gui/components/shirt.png");
    public static final IdentifierRef CIRCLE_X = IdentifierRef.ofSaturn("textures/gui/components/circle_x.png");
    public static final IdentifierRef INFO = IdentifierRef.ofSaturn("textures/gui/components/info.png");
    public static final IdentifierRef CHECK = IdentifierRef.ofSaturn("textures/gui/components/check.png");

    public static final IdentifierRef LOGO = IdentifierRef.ofSaturn("textures/logo/logo.png");
    public static final IdentifierRef REALISTIC_LOGO = IdentifierRef.ofSaturn("textures/logo/realistic.png");
    public static final IdentifierRef LOGO_TEXT = IdentifierRef.ofSaturn("textures/logo/text.png");
    public static final IdentifierRef LOGO_TEXT_BIG = IdentifierRef.ofSaturn("textures/logo/text_big.png");
    public static final IdentifierRef SPLASH = IdentifierRef.ofSaturn("textures/gui/splash.png");

    // Widgets
    public static final IdentifierRef BUTTON_BORDER = IdentifierRef.ofSaturn("button_border");
    public static final IdentifierRef BUTTON = IdentifierRef.ofSaturn("button");
    public static final IdentifierRef BUTTON_OP = IdentifierRef.ofSaturn("button_op");
    public static final IdentifierRef SETTINGS_BG = IdentifierRef.ofSaturn("settings_bg");
    public static final IdentifierRef RECT = IdentifierRef.ofSaturn("rect");
    public static final IdentifierRef RECT_BORDER = IdentifierRef.ofSaturn("rect_border");
    public static final IdentifierRef MOD = IdentifierRef.ofSaturn("textures/gui/components/mod.png");
    public static final IdentifierRef MOD_BG = IdentifierRef.ofSaturn("textures/gui/components/mod_bg.png");

    public static IdentifierRef getCloakPreview(String cloak) {
        return IdentifierRef.ofSaturn("textures/gui/cloak/" + (cloak.isEmpty() ? "none" : cloak) + ".png");
    }

    public static IdentifierRef getHatPreview(String hat) {
        return IdentifierRef.ofSaturn("textures/gui/hat/" + (hat.isEmpty() ? "none" : hat) + ".png");
    }

    public static IdentifierRef getEmotePreview(String emote) {
        return IdentifierRef.ofSaturn("textures/gui/emote/" + (emote == null ? "none" : emote) + ".png");
    }

    public static IdentifierRef getModIcon(String modId) {
        return IdentifierRef.ofSaturn("textures/gui/mod/" + modId + ".svg");
    }

}

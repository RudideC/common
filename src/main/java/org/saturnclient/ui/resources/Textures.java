package org.saturnclient.ui.resources;

import org.saturnclient.common.ref.asset.IdentifierRef;

public class Textures {
        public static final IdentifierRef CROSSHAIR_RANGE = new IdentifierRef("saturnclient",
                        "textures/gui/hud/crosshair_range.png");
        public static final IdentifierRef COSMETICS = new IdentifierRef("saturnclient",
                        "textures/gui/components/cosmetics.png");
        public static final IdentifierRef HUD_ICON = new IdentifierRef("saturnclient",
                        "textures/gui/components/hud.png");
        public static final IdentifierRef SEARCH = new IdentifierRef("saturnclient",
                        "textures/gui/components/search.png");
        public static final IdentifierRef CLOSE = new IdentifierRef("saturnclient",
                        "textures/gui/components/close.png");
        public static final IdentifierRef MODS_TAB = new IdentifierRef("saturnclient",
                        "textures/gui/components/mods_tab.png");
        public static final IdentifierRef SETTINGS = new IdentifierRef("saturnclient",
                        "textures/gui/components/settings.png");
        public static final IdentifierRef CLOAK = new IdentifierRef("saturnclient",
                        "textures/gui/components/cloak.png");
        public static final IdentifierRef HAT = new IdentifierRef("saturnclient",
                        "textures/gui/components/hat.png");
        public static final IdentifierRef RESET = new IdentifierRef("saturnclient",
                        "textures/gui/components/reset.png");
        public static final IdentifierRef TOGGLE_INDICATOR = new IdentifierRef("saturnclient",
                        "textures/gui/components/toggle_indicator.png");
        public static final IdentifierRef LEFT = new IdentifierRef("saturnclient",
                        "textures/gui/components/left.png");
        public static final IdentifierRef RIGHT = new IdentifierRef("saturnclient",
                        "textures/gui/components/right.png");
        public static final IdentifierRef STORE = new IdentifierRef("saturnclient",
                        "textures/gui/components/store.png");
        public static final IdentifierRef COINS = new IdentifierRef("saturnclient",
                        "textures/gui/components/coins.png");
        public static final IdentifierRef SHIRT = new IdentifierRef("saturnclient",
                        "textures/gui/components/shirt.png");
        public static final IdentifierRef CIRCLE_X = new IdentifierRef("saturnclient",
                        "textures/gui/components/circle_x.png");
        public static final IdentifierRef INFO = new IdentifierRef("saturnclient",
                        "textures/gui/components/info.png");
        public static final IdentifierRef CHECK = new IdentifierRef("saturnclient",
                        "textures/gui/components/check.png");

        public static final IdentifierRef LOGO = new IdentifierRef("saturnclient", "textures/logo/logo.png");
        public static final IdentifierRef REALISTIC_LOGO = new IdentifierRef("saturnclient",
                        "textures/logo/realistic.png");
        public static final IdentifierRef LOGO_TEXT = new IdentifierRef("saturnclient", "textures/logo/text.png");
        public static final IdentifierRef LOGO_TEXT_BIG = new IdentifierRef("saturnclient",
                        "textures/logo/text_big.png");
        public static final IdentifierRef SPLASH = new IdentifierRef("saturnclient", "textures/gui/splash.png");

        // Widgets
        public static final IdentifierRef BUTTON_BORDER = new IdentifierRef("saturnclient", "button_border");
        public static final IdentifierRef BUTTON = new IdentifierRef("saturnclient", "button");
        public static final IdentifierRef BUTTON_OP = new IdentifierRef("saturnclient", "button_op");
        public static final IdentifierRef SETTINGS_BG = new IdentifierRef("saturnclient", "settings_bg");
        public static final IdentifierRef RECT = new IdentifierRef("saturnclient", "rect");
        public static final IdentifierRef RECT_BORDER = new IdentifierRef("saturnclient", "rect_border");
        public static final IdentifierRef MOD = new IdentifierRef("saturnclient",
                        "textures/gui/components/mod.png");
        public static final IdentifierRef MOD_BG = new IdentifierRef("saturnclient",
                        "textures/gui/components/mod_bg.png");

        public static IdentifierRef getCloakPreview(String cloak) {
                return new IdentifierRef("saturnclient",
                                "textures/gui/cloak/" + (cloak.isEmpty() ? "none" : cloak) + ".png");
        }

        public static IdentifierRef getHatPreview(String hat) {
                return new IdentifierRef("saturnclient",
                                "textures/gui/hat/" + (hat.isEmpty() ? "none" : hat) + ".png");
        }

        public static IdentifierRef getEmotePreview(String emote) {
                return new IdentifierRef("saturnclient",
                                "textures/gui/emote/" + (emote == null ? "none" : emote) + ".png");
        }

        public static IdentifierRef getModIcon(String modId) {
                return new IdentifierRef("saturnclient", "textures/gui/mod/" + modId + ".svg");
        }

}

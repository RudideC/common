package org.saturnclient.feature;

import java.util.ArrayList;
import java.util.List;

public class FeatureManager {
    public static List<Feature> ENABLED_MODS = new ArrayList<>();
    public static Feature[] MODS = {};

    public static void init(ModuleProvider provider) {
        MODS = provider.getMods();
        updateEnabledModules();
    }

    public static synchronized void updateEnabledModules() {
        ENABLED_MODS.clear();
        for (Feature m : MODS) {
            if (m.isEnabled()) {
                ENABLED_MODS.add(m);
            }
        }
    }

    public static Feature[] getAllMods() {
        return MODS;
    }

    public interface ModuleProvider {
        Feature[] getMods();
    }
}

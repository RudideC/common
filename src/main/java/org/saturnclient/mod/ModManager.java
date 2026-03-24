package org.saturnclient.mod;

import java.util.ArrayList;
import java.util.List;

import org.saturnclient.mod.mods.*;

public class ModManager {
    public static List<Mod> ENABLED_MODS = new ArrayList<>();
    public static Mod[] MODS = {
            new ArmorDisplayFeature(), new DayCounterFeature(), new KeystrokesFeature(), new StatusEffectsFeature(),
            new AutoSprintFeature(), new FpsFeature(), new NametagsFeature(), new TpsFeature(),
            new ClockFeature(), new FreelookFeature(), new NoFogFeature(), new ZoomFeature(),
            new CoordinatesFeature(), new FullbrightFeature(), new PingFeature(),
            new CrosshairFeature(), new HealthDisplayFeature(), new SpeedometerFeature(),
    };

    public static void init() {
        updateEnabledModules();
    }

    public static synchronized void updateEnabledModules() {
        ENABLED_MODS.clear();
        for (Mod m : MODS) {
            if (m.isEnabled()) {
                ENABLED_MODS.add(m);
            }
        }
    }
}

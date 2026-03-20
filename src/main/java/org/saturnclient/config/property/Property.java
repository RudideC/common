package org.saturnclient.config.property;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public abstract class Property {
    public boolean isReset = false;

    // ---------- Factory Methods ----------

    public static NamespaceProperty namespace(Map<String, Property> value) {
        return new NamespaceProperty(value);
    }

    public static BoolProperty bool(boolean value) {
        return new BoolProperty(value);
    }

    public static IntProperty integer(int value) {
        return new IntProperty(value);
    }

    public static FloatProperty floatProp(float value) {
        return new FloatProperty(value);
    }

    public static StringProperty string(String value) {
        return new StringProperty(value);
    }

    public static ColorProperty color(int value) {
        return new ColorProperty(value);
    }

    public static KeybindingProperty keybinding(int value) {
        return new KeybindingProperty(value);
    }

    public static SelectProperty font(int value) {
        return select(value, "Default", "Inter", "Inter bold");
    }

    public static SelectProperty select(Integer value, String... availableValues) {
        return new SelectProperty(value, availableValues);
    }

    // ---------- Utility ----------

    public NamedProperty named(String name) {
        return new NamedProperty(name, this);
    }

    public void reset() {
    }

    // ---------- JSON Serialization ----------

    public abstract JsonNode toJson();

    public abstract void loadFromJson(JsonNode element);
}
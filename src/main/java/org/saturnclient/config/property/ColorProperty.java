package org.saturnclient.config.property;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class ColorProperty extends Property {
    public int value;
    public final int defaultValue;

    public ColorProperty(int defaultValue) {
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    @Override
    public JsonNode toJson() {
        return JsonNodeFactory.instance.textNode(
                String.format("#%08X", this.value));
    }

    @Override
    public void loadFromJson(JsonNode element) {
        if (element.isTextual())
            this.value = ColorProperty.parseHexToInt(element.textValue());
    }

    public static int parseHexToInt(String hex) {

        hex = hex.replace("#", "");

        if (hex.length() == 6)
            hex = "FF" + hex;

        if (hex.length() != 8)
            throw new IllegalArgumentException(
                    "Hex must be 6 or 8 chars long, got '" + hex + "'");

        return (int) Long.parseLong(hex, 16);
    }
}

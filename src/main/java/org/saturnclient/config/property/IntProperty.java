package org.saturnclient.config.property;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class IntProperty extends Property {
    public int value;
    public final int defaultValue;

    public IntProperty(int defaultValue) {
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    @Override
    public JsonNode toJson() {
        return JsonNodeFactory.instance.numberNode(this.value);
    }

    @Override
    public void loadFromJson(JsonNode element) {
        if (element.isInt())
            this.value = element.intValue();
        else if (element.isTextual())
            this.value = ColorProperty.parseHexToInt(element.textValue());
    }
}

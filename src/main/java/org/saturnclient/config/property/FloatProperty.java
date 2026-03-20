package org.saturnclient.config.property;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class FloatProperty extends Property {
    public float value;
    public final float defaultValue;

    public FloatProperty(float defaultValue) {
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    @Override
    public JsonNode toJson() {
        return JsonNodeFactory.instance.numberNode(this.value);
    }

    @Override
    public void loadFromJson(JsonNode element) {
        if (element.isNumber())
            this.value = element.floatValue();
    }
}

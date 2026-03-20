package org.saturnclient.config.property;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class BoolProperty extends Property {
    public boolean value;
    public final boolean defaultValue;

    public BoolProperty(boolean defaultValue) {
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    @Override
    public JsonNode toJson() {
        return JsonNodeFactory.instance.booleanNode(this.value);
    }

    @Override
    public void loadFromJson(JsonNode element) {
        if (element.isBoolean())
            this.value = element.booleanValue();
    }
}

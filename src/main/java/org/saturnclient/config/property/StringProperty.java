package org.saturnclient.config.property;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class StringProperty extends Property {
    public String value;
    public final String defaultValue;

    public StringProperty(String defaultValue) {
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    @Override
    public JsonNode toJson() {
        return JsonNodeFactory.instance.textNode(this.value);
    }

    @Override
    public void loadFromJson(JsonNode element) {
        if (element.isTextual())
            this.value = element.textValue();
    }
}

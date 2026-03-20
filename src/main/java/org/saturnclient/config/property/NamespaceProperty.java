package org.saturnclient.config.property;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class NamespaceProperty extends Property {
    public final Map<String, Property> value;

    public NamespaceProperty(Map<String, Property> value) {
        this.value = value;
    }

    @Override
    public JsonNode toJson() {
        ObjectNode nested = JsonNodeFactory.instance.objectNode();

        this.value.forEach((k, v) -> {
            nested.set(k, v.toJson());
        });

        return nested;
    }

    @Override
    public void loadFromJson(JsonNode element) {
        if (element.isObject()) {
            ObjectNode obj = (ObjectNode) element;

            this.value.forEach((k, v) -> {
                JsonNode e = obj.get(k);

                if (e == null)
                    return;

                v.loadFromJson(e);
            });
        }
    }

    public Map<String, Property> getNamespaceMap() {
        return this.value;
    }
}

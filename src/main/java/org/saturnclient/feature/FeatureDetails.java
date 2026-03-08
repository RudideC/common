package org.saturnclient.feature;

public class FeatureDetails {
    public String name;
    public String namespace;
    public String description;
    public String version;
    public String[] tags = {};

    public FeatureDetails(String name, String namespace) {
        this.name = name;
        this.namespace = namespace;
    }

    public FeatureDetails name(String name) {
        this.name = name;
        return this;
    }

    public FeatureDetails namespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public FeatureDetails description(String description) {
        this.description = description;
        return this;
    }

    public FeatureDetails version(String version) {
        this.version = version;
        return this;
    }

    public FeatureDetails tags(String... tags) {
        this.tags = tags;
        return this;
    }
}

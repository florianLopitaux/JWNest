package fr.jwnest.utils;

import java.util.*;
import java.lang.reflect.Field;

public final class ToStringBuilder {
    // FIELDS
    private final StringBuilder builder;
    private final String className;
    private final List<String> attributes;


    // CONSTRUCTOR
    public ToStringBuilder(Class<?> classUsed) {
        this.builder = new StringBuilder();
        this.className = classUsed.getSimpleName();
        this.attributes = new ArrayList<>();

        for (final Field currentField : classUsed.getDeclaredFields()) {
            this.attributes.add(currentField.getName());
        }
    }


    // GETTERS
    public String getClassName() {
        return this.className;
    }

    public List<String> getAttributes() {
        return Collections.unmodifiableList(this.attributes);
    }


    // PUBLIC METHODS
    public String build(Object... values) throws IllegalArgumentException {
        if (!this.checkNumberOfValues(values)) {
            throw new IllegalArgumentException("The number of values has to be the same of attributes !");
        }

        this.resetBuilder();
        this.buildAllFields(Arrays.asList(values));
        this.builder.append('}');

        return this.builder.toString();
    }


    // PRIVATE METHODS
    private void buildAllFields(List<Object> values) {
        // initialize iterators of the lists
        Iterator<String> attributeIterator = this.attributes.iterator();
        Iterator<Object> valueIterator = values.iterator();

        // build all fields of the class
        while (attributeIterator.hasNext() && valueIterator.hasNext()){
            this.buildSingleAttribute(attributeIterator.next(), valueIterator.next());
            this.builder.append(", ");
        }

        // remove the last comma and space character
        this.builder.setLength(this.builder.length() - 2);
    }

    private void buildSingleAttribute(String attribute, Object value) {
        this.builder.append(attribute).append('=');

        if (value instanceof String) {
            this.builder.append('"').append(value).append('"');
        } else {
            this.builder.append(value);
        }
    }

    private void resetBuilder() {
        this.builder.setLength(0);
        this.builder.append(this.className).append('{');
    }

    private boolean checkNumberOfValues(Object[] values) {
        return this.attributes.size() == values.length;
    }
}

package fr.jwnest.htmlmaker;

import fr.jwnest.utils.ToStringBuilder;

import java.util.*;

public class HTMLNode {

    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------

    private final HTMLTag tag;
    private final List<HTMLNode> children;
    private final EnumMap<HTMLAttribute, String> attributes;

    private String name;
    private String value;

    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------

    public HTMLNode(HTMLTag tag) {
        this.tag = tag;
        this.children = new ArrayList<>();
        this.attributes = new EnumMap<>(HTMLAttribute.class);
        this.name = UUID.randomUUID().toString();
    }

    public HTMLNode(HTMLTag tag, String value) {
        this(tag);
        this.value = value;
    }

    public HTMLNode(HTMLTag tag, EnumMap<HTMLAttribute, String> attributes) throws IllegalArgumentException {
        this(tag);

        for (Map.Entry<HTMLAttribute, String> entry : attributes.entrySet()) {
            this.setAttribute(entry.getKey(), entry.getValue());
        }
    }

    public HTMLNode(HTMLTag tag, String value, EnumMap<HTMLAttribute, String> attributes) throws IllegalArgumentException {
        this(tag, attributes);
        this.value = value;
    }

    // ------------------------------------------------------------------------
    // GETTERS
    // ------------------------------------------------------------------------

    public HTMLTag getTag() {
        return this.tag;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public List<HTMLNode> getChildren() {
        return Collections.unmodifiableList(this.children);
    }

    public HTMLNode getChild(String nodeName) {
        for (final HTMLNode child : this.children) {
            if (child.name.equals(nodeName)) {
                return child;
            }
        }

        return null;
    }

    public String getAttribute(HTMLAttribute attribute) {
        return this.attributes.get(attribute);
    }

    public EnumMap<HTMLAttribute, String> getAttributes() {
        return new EnumMap<>(this.attributes);
    }

    public EnumSet<HTMLAttribute> getAuthorizedAttributes() {
        return EnumSet.copyOf(this.attributes.keySet());
    }

    // ------------------------------------------------------------------------
    // SETTERS
    // ------------------------------------------------------------------------

    public void setName(String nodeName) {
        this.name = nodeName;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addChild(HTMLNode child) {
        this.children.add(child);
    }

    public void addChildren(List<HTMLNode> children) {
        this.children.addAll(children);
    }

    public boolean removeChildren(HTMLNode child) {
        return this.children.remove(child);
    }

    public boolean removeChildren(String nodeName) {
        boolean found = false;

        for (final HTMLNode child : this.children) {
            if (child.name.equals(nodeName)) {
                this.children.remove(child);
                found = true;
            }
        }

        return found;
    }

    public void setAttribute(HTMLAttribute attribute) throws IllegalArgumentException {
        if (this.tag.getAuthorizedAttributes().contains(attribute)) {
            this.attributes.put(attribute, "");
        } else {
            throw new IllegalArgumentException("Attribute " + attribute + " not supported for this tag " + this.tag);
        }
    }

    public void setAttribute(HTMLAttribute attribute, String value) throws IllegalArgumentException {
        if (this.tag.getAuthorizedAttributes().contains(attribute)) {
            this.attributes.put(attribute, value);
        } else {
            throw new IllegalArgumentException("Attribute " + attribute + " not supported for this tag " + this.tag);
        }
    }

    public boolean removeAttribute(HTMLAttribute attribute) {
        return this.attributes.remove(attribute) != null;
    }

    // ------------------------------------------------------------------------
    // PUBLIC METHODS
    // ------------------------------------------------------------------------

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    public boolean hasChild(HTMLNode node) {
        return this.children.contains(node);
    }

    public boolean hasChild(String nodeName) {
        for (final HTMLNode child : this.children) {
            if (child.name.equals(nodeName)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasAttribute(HTMLAttribute attribute) {
        return this.attributes.containsKey(attribute);
    }

    public void clearChildren() {
        this.children.clear();
    }

    public void clearAttributes() {
        this.attributes.clear();
    }

    public String serialize() {
        return this.serialize(4);
    }

    public String serialize(int indent) {
        return this.serialize(indent, indent);
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private String serialize(int defaultIndentSpacesCount, int repeatIndentCount) {
        final String indentChars = " ".repeat(repeatIndentCount);
        final StringBuilder builder = new StringBuilder();

        // build html open tag with all of this attributes
        builder.append('<').append(this.tag);
        for (final Map.Entry<HTMLAttribute, String> attribute : this.attributes.entrySet()) {
            builder.append(' ').append(attribute.getKey()).append('=').append(attribute.getValue());
        }
        builder.append('>');

        // build node value if its set
        if (this.value != null) {
            builder.append('\n').append(indentChars).append(this.value).append('\n');
        }

        // build all node's children
        for (final HTMLNode child : this.children) {
            builder.append('\n').append(indentChars).append(child.serialize(defaultIndentSpacesCount, repeatIndentCount + defaultIndentSpacesCount));
        }

        // close the html tag
        builder.append("</").append(this.tag).append('>').append('\n');

        return builder.toString();
    }

    // ------------------------------------------------------------------------
    // OVERRIDE METHODS FROM Object CLASS
    // ------------------------------------------------------------------------

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }

        final HTMLNode htmlNode = (HTMLNode) other;
        return this.tag.equals(htmlNode.tag) && name.equals(htmlNode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, name);
    }

    @Override
    public String toString() {
        final ToStringBuilder builder = new ToStringBuilder(HTMLNode.class);
        return builder.build(this.tag, this.children, this.attributes, this.name, this.value);
    }
}

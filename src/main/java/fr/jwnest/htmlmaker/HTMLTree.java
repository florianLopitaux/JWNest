package fr.jwnest.htmlmaker;

public class HTMLTree extends HTMLNode {

    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------

    protected HTMLHeadNode head;
    protected HTMLNode header;
    protected HTMLNode footer;

    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------

    public HTMLTree() {
        super(HTMLTag.HTML);

        this.head = new HTMLHeadNode();
        this.addChild(this.head);

        this.header = new HTMLNode(HTMLTag.HEADER);
        this.footer = new HTMLNode(HTMLTag.FOOTER);
    }

    public HTMLTree(String lang) {
        this();
        this.setAttribute(HTMLAttribute.LANG, lang);
    }

    // ------------------------------------------------------------------------
    // OVERRIDE METHODS FROM HTMLNode CLASS
    // ------------------------------------------------------------------------

    @Override
    public String serialize() {
        return "<!DOCTYPE html>\n" + super.serialize();
    }

    @Override
    public String serialize(int indent) {
        return "<!DOCTYPE html>\n" + super.serialize(indent);
    }

    // ------------------------------------------------------------------------
    // PROTECTED METHODS
    // ------------------------------------------------------------------------

    protected void buildHeader() {
        this.removeChildren(this.header);

        if (!this.header.isLeaf()) {
            this.addChild(this.header);
        }
    }

    protected void buildFooter() {
        this.removeChildren(this.footer);

        if (!this.footer.isLeaf()) {
            this.addChild(this.footer);
        }
    }
}

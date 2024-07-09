package fr.jwnest.htmlmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class HTMLHeadNode extends HTMLNode {

    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------

    private static final String CSS_LINK_NAME = "head-css-link-node";
    private static final String SCRIPTS_NAME = "head-script-node";

    private String defaultPath;

    private final Set<String> cssFiles;
    private final Set<String> scriptFiles;
    private final List<String> scripts;

    private final HTMLNode titleNode;
    private final HTMLNode charsetEncoding;
    private final HTMLNode viewport;

    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------

    public HTMLHeadNode() {
        super(HTMLTag.HEAD);
        this.setName("tree-head");

        this.defaultPath = "target/classes/";

        this.cssFiles = new HashSet<>();
        this.scriptFiles = new HashSet<>();
        this.scripts = new ArrayList<>();

        this.titleNode = new HTMLNode(HTMLTag.TITLE);
        this.charsetEncoding = new HTMLNode(HTMLTag.META, new EnumMap<>(Map.of(HTMLAttribute.CHARSET, "UTF-8")));
        this.viewport = new HTMLNode(HTMLTag.META, new EnumMap<>(Map.of(
            HTMLAttribute.NAME, "viewport",
            HTMLAttribute.CONTENT, "width=device-width,initial-scale=1"))
        );
    }

    public HTMLHeadNode(String title) {
        this();
        this.titleNode.setValue(title);
    }

    // ------------------------------------------------------------------------
    // GETTERS
    // ------------------------------------------------------------------------

    public String getDefaultPath() {
        return this.defaultPath;
    }

    public String getPageTitle() {
        return this.titleNode.getValue();
    }

    public String getPageEncodingCharset() {
        return this.charsetEncoding.getAttribute(HTMLAttribute.CHARSET);
    }

    public String getPageViewport() {
        return this.viewport.getAttribute(HTMLAttribute.CONTENT);
    }

    // ------------------------------------------------------------------------
    // SETTERS
    // ------------------------------------------------------------------------

    public void setDefaultPath(String defaultPath) {
        this.defaultPath = defaultPath;
    }

    public void setPageTitle(String title) {
        this.titleNode.setValue(title);
    }

    public void setPageEncodingCharset(String encoding) {
        this.charsetEncoding.setAttribute(HTMLAttribute.CHARSET, encoding);
    }

    public void setPageViewport(String viewport) {
        this.viewport.setAttribute(HTMLAttribute.CONTENT, viewport);
    }

    public boolean addCssFile(String filepath) throws FileNotFoundException {
        return this.cssFiles.add(this.checkFilePath(filepath));
    }

    public boolean addScriptFile(String filepath) throws FileNotFoundException {
        return this.scriptFiles.add(this.checkFilePath(filepath));
    }

    public void addScript(String scriptValue) {
        this.scripts.add(scriptValue);
    }

    // ------------------------------------------------------------------------
    // OVERRIDE METHODS FROM HTMLNode CLASS
    // ------------------------------------------------------------------------

    @Override
    public String serialize(int indent) {
        // clear all children if already exists
        this.removeChildren(this.titleNode);
        this.removeChildren(HTMLHeadNode.CSS_LINK_NAME);
        this.removeChildren(HTMLHeadNode.SCRIPTS_NAME);

        // re-create children
        if (!this.titleNode.getValue().isEmpty()) {
            this.addChild(this.titleNode);
        }
        this.addChild(this.charsetEncoding);
        this.addChild(this.viewport);

        this.createCssNodes();
        this.createScriptNodes();

        // now, we can serialize the head node
        return super.serialize(indent);
    }

    // ------------------------------------------------------------------------
    // PRIVATE METHODS
    // ------------------------------------------------------------------------

    private String checkFilePath(String filepath) throws FileNotFoundException {
        // try to find the file with default path before
        Path path = Path.of(this.defaultPath + filepath);
        if (Files.exists(path)) {
            return this.defaultPath + filepath;
        }

        // file doesn't exist, try to find them without the default path
        path = Path.of(filepath);
        if (Files.exists(path)) {
            return filepath;
        }

        // file doesn't found, raise exception
        throw new FileNotFoundException(filepath);
    }

    private void createCssNodes() {
        for (final String cssFile : this.cssFiles) {
            final HTMLNode linkNode = new HTMLNode(HTMLTag.LINK, new EnumMap<>(Map.of(
                HTMLAttribute.HREF, cssFile,
                HTMLAttribute.REL, "stylesheet",
                HTMLAttribute.TYPE, "text/css"
            )));
            linkNode.setName(HTMLHeadNode.CSS_LINK_NAME);

            this.addChild(linkNode);
        }
    }

    private void createScriptNodes() {
        for (final String scriptFile : this.scriptFiles) {
            final HTMLNode scriptNode = new HTMLNode(HTMLTag.SCRIPT, new EnumMap<>(Map.of(
                HTMLAttribute.TYPE, "text/javascript",
                HTMLAttribute.SRC, scriptFile
            )));
            scriptNode.setName(HTMLHeadNode.SCRIPTS_NAME);

            this.addChild(scriptNode);
        }

        for (final String scriptValue : this.scripts) {
            final HTMLNode scriptNode = new HTMLNode(HTMLTag.SCRIPT, scriptValue);
            scriptNode.setAttribute(HTMLAttribute.TYPE, "text/javascript");
            scriptNode.setName(HTMLHeadNode.SCRIPTS_NAME);

            this.addChild(scriptNode);
        }
    }
}

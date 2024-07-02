package fr.jwnest.htmlmaker;

import java.util.*;

public enum HTMLTag {
    // MAIN ROOT
    HTML,

    // DOCUMENT METADATA
    BASE (HTMLAttribute.HREF, HTMLAttribute.TARGET),
    HEAD,
    LINK (HTMLAttribute.AS, HTMLAttribute.CROSS_ORIGIN, HTMLAttribute.HREF, HTMLAttribute.HREF_LANG, HTMLAttribute.INTEGRITY, HTMLAttribute.MEDIA, HTMLAttribute.REFERRER_POLICY, HTMLAttribute.REL, HTMLAttribute.SIZES, HTMLAttribute.TYPE),
    META (HTMLAttribute.CHARSET, HTMLAttribute.CONTENT, HTMLAttribute.HTTP_EQUIV, HTMLAttribute.NAME),
    STYLE (HTMLAttribute.MEDIA, HTMLAttribute.TYPE),
    TITLE,

    // SECTIONING ROOT
    BODY,

    // CONTENT SECTIONING
    ADDRESS,
    ARTICLE,
    ASIDE,
    FOOTER,
    HEADER,
    H1,
    H2,
    H3,
    H4,
    H5,
    H6,
    HGROUP,
    MAIN,
    NAV,
    SECTION,
    SEARCH,

    // TEXT CONTENT
    BLOCKQUOTE (HTMLAttribute.CITE),
    DD,
    DIV,
    DL,
    DT,
    FIGCAPTION,
    FIGURE,
    HR,
    LI (HTMLAttribute.VALUE),
    MENU (HTMLAttribute.TYPE),
    OL (HTMLAttribute.REVERSED, HTMLAttribute.START, HTMLAttribute.TYPE),
    P,
    PRE,
    UL,

    // INLINE TEXT SEMANTICS
    A (HTMLAttribute.DOWNLOAD, HTMLAttribute.HREF, HTMLAttribute.HREF_LANG, HTMLAttribute.MEDIA, HTMLAttribute.PING, HTMLAttribute.REFERRER_POLICY, HTMLAttribute.REL, HTMLAttribute.SHAPE, HTMLAttribute.TARGET),
    ABBR,
    B,
    BDI,
    BDO,
    BR,
    CITE,
    CODE,
    DATA (HTMLAttribute.VALUE),
    DFN,
    EM,
    I,
    KDB,
    MARK,
    Q (HTMLAttribute.CITE),
    RP,
    RT,
    RUBY,
    S,
    SAMP,
    SMALL,
    SPAN,
    STRONG,
    SUB,
    SUP,
    TIME (HTMLAttribute.DATETIME),
    U,
    VAR,
    WBR,

    // IMAGE AND MULTIMEDIA
    AREA (HTMLAttribute.ALT, HTMLAttribute.COORDS, HTMLAttribute.DOWNLOAD, HTMLAttribute.HREF, HTMLAttribute.MEDIA, HTMLAttribute.PING, HTMLAttribute.REFERRER_POLICY, HTMLAttribute.REL, HTMLAttribute.SHAPE, HTMLAttribute.TARGET),
    AUDIO (HTMLAttribute.AUTO_PLAY, HTMLAttribute.CONTROLS, HTMLAttribute.CROSS_ORIGIN, HTMLAttribute.LOOP, HTMLAttribute.MUTED, HTMLAttribute.PRELOAD, HTMLAttribute.SRC),
    IMG (HTMLAttribute.ALT, HTMLAttribute.CROSS_ORIGIN, HTMLAttribute.DECODING, HTMLAttribute.INTRINSIC_SIZE, HTMLAttribute.IS_MAP, HTMLAttribute.LOADING, HTMLAttribute.REFERRER_POLICY, HTMLAttribute.SIZES, HTMLAttribute.SRC, HTMLAttribute.SRC_SET, HTMLAttribute.USE_MAP),
    MAP (HTMLAttribute.NAME),
    TRACK (HTMLAttribute.DEFAULT, HTMLAttribute.KIND, HTMLAttribute.LABEL, HTMLAttribute.SRC, HTMLAttribute.SRC_LANG),
    VIDEO (HTMLAttribute.AUTO_PLAY, HTMLAttribute.CONTROLS, HTMLAttribute.CROSS_ORIGIN, HTMLAttribute.LOOP, HTMLAttribute.MUTED, HTMLAttribute.PLAYS_IN_LINE, HTMLAttribute.POSTER, HTMLAttribute.PRELOAD, HTMLAttribute.SRC),

    // EMBEDDED CONTENT
    EMBED (HTMLAttribute.SRC, HTMLAttribute.TYPE),
    IFRAME (HTMLAttribute.ALLOW, HTMLAttribute.CSP, HTMLAttribute.LOADING, HTMLAttribute.NAME, HTMLAttribute.REFERRER_POLICY, HTMLAttribute.SANDBOX, HTMLAttribute.SRC, HTMLAttribute.SRC_DOC),
    OBJECT (HTMLAttribute.DATA, HTMLAttribute.FORM, HTMLAttribute.NAME, HTMLAttribute.TYPE, HTMLAttribute.USE_MAP),
    PICTURE,
    PORTAL,
    SOURCE (HTMLAttribute.MEDIA, HTMLAttribute.SIZES, HTMLAttribute.SRC, HTMLAttribute.SRC_SET, HTMLAttribute.TYPE),

    // SVG AND MATHML
    SVG,
    MATH,

    // SCRIPTING
    CANVAS,
    NOSCRIPT,
    SCRIPT (HTMLAttribute.ASYNC, HTMLAttribute.CROSS_ORIGIN, HTMLAttribute.DEFER, HTMLAttribute.INTEGRITY, HTMLAttribute.REFERRER_POLICY, HTMLAttribute.SRC, HTMLAttribute.TYPE),

    // DEMARCATING EDITS
    DEL (HTMLAttribute.CITE, HTMLAttribute.DATETIME),
    INS (HTMLAttribute.CITE, HTMLAttribute.DATETIME),

    // TABLE CONTENT
    CAPTION,
    COL (HTMLAttribute.SPAN),
    COLGROUP (HTMLAttribute.SPAN),
    TABLE (HTMLAttribute.SUMMARY),
    TBODY,
    TD (HTMLAttribute.COLSPAN, HTMLAttribute.HEADERS, HTMLAttribute.ROWSPAN),
    TFOOT,
    TH (HTMLAttribute.COLSPAN, HTMLAttribute.HEADERS, HTMLAttribute.ROWSPAN, HTMLAttribute.SCOPE),
    THEAD,
    TR,

    // FORMS
    BUTTON (HTMLAttribute.DISABLED, HTMLAttribute.FORM, HTMLAttribute.FORM_ACTION, HTMLAttribute.FORM_ENCTYPE, HTMLAttribute.FORM_METHOD, HTMLAttribute.FORM_NO_VALIDATE, HTMLAttribute.FORM_TARGET, HTMLAttribute.NAME, HTMLAttribute.TYPE, HTMLAttribute.VALUE),
    DATALIST,
    FIELDSET (HTMLAttribute.DISABLED, HTMLAttribute.FORM, HTMLAttribute.NAME),
    FORM (HTMLAttribute.ACCEPT, HTMLAttribute.ACCEPT__CHARSET, HTMLAttribute.ACTION, HTMLAttribute.AUTO_COMPLETE, HTMLAttribute.ENCTYPE, HTMLAttribute.METHOD, HTMLAttribute.NAME, HTMLAttribute.NO_VALIDATE, HTMLAttribute.TARGET),
    INPUT (HTMLAttribute.ACCEPT, HTMLAttribute.ALT, HTMLAttribute.AUTO_COMPLETE, HTMLAttribute.CAPTURE, HTMLAttribute.CHECKED, HTMLAttribute.DIRNAME, HTMLAttribute.DISABLED, HTMLAttribute.FORM, HTMLAttribute.FORM_ACTION, HTMLAttribute.FORM_ENCTYPE, HTMLAttribute.FORM_METHOD, HTMLAttribute.FORM_NO_VALIDATE, HTMLAttribute.FORM_TARGET, HTMLAttribute.LIST, HTMLAttribute.MAX, HTMLAttribute.MAX_LENGTH, HTMLAttribute.MIN_LENGTH, HTMLAttribute.MIN, HTMLAttribute.MULTIPLE, HTMLAttribute.NAME, HTMLAttribute.PATTERN, HTMLAttribute.PLACEHOLDER, HTMLAttribute.READONLY, HTMLAttribute.REQUIRED, HTMLAttribute.SIZE, HTMLAttribute.SRC, HTMLAttribute.STEP, HTMLAttribute.TYPE, HTMLAttribute.USE_MAP, HTMLAttribute.VALUE),
    LABEL (HTMLAttribute.FOR, HTMLAttribute.FORM),
    LEGEND,
    METER (HTMLAttribute.FORM, HTMLAttribute.HIGH, HTMLAttribute.LOW, HTMLAttribute.MAX, HTMLAttribute.MIN, HTMLAttribute.OPTIMUM, HTMLAttribute.VALUE),
    OPTGROUP (HTMLAttribute.DISABLED, HTMLAttribute.LABEL),
    OPTION (HTMLAttribute.DISABLED, HTMLAttribute.LABEL, HTMLAttribute.SELECTED, HTMLAttribute.VALUE),
    OUTPUT (HTMLAttribute.FOR, HTMLAttribute.FORM, HTMLAttribute.NAME),
    PROGRESS (HTMLAttribute.FORM, HTMLAttribute.MAX, HTMLAttribute.VALUE),
    SELECT (HTMLAttribute.AUTO_COMPLETE, HTMLAttribute.DISABLED, HTMLAttribute.FORM, HTMLAttribute.MULTIPLE, HTMLAttribute.NAME, HTMLAttribute.REQUIRED, HTMLAttribute.SIZE),
    TEXTAREA (HTMLAttribute.AUTO_COMPLETE, HTMLAttribute.COLS, HTMLAttribute.DIRNAME, HTMLAttribute.DISABLED, HTMLAttribute.ENTER_KEY_INT, HTMLAttribute.FORM, HTMLAttribute.INPUT_MODE, HTMLAttribute.MAX_LENGTH, HTMLAttribute.MIN_LENGTH, HTMLAttribute.NAME, HTMLAttribute.PLACEHOLDER, HTMLAttribute.READONLY, HTMLAttribute.REQUIRED, HTMLAttribute.ROWS, HTMLAttribute.WRAP),

    // INTERACTIVE ELEMENTS
    DETAILS (HTMLAttribute.OPEN),
    DIALOG (HTMLAttribute.OPEN),
    SUMMARY,

    // WEB COMPONENTS
    SLOT,
    TEMPLATE;


    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------

    private final Set<HTMLAttribute> authorizedAttributes;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------------------------

    HTMLTag(HTMLAttribute... attributes) {
        this.authorizedAttributes = new HashSet<>(HTMLAttribute.GLOBAL_ATTRIBUTES);
        this.authorizedAttributes.addAll(Arrays.asList(attributes));
    }

    // ------------------------------------------------------------------------
    // GETTERS
    // ------------------------------------------------------------------------

    public Set<HTMLAttribute> getAuthorizedAttributes() {
        return Collections.unmodifiableSet(authorizedAttributes);
    }

    // ------------------------------------------------------------------------
    // OVERRIDE METHODS FROM Enum CLASS
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    // ------------------------------------------------------------------------
    // PUBLIC STATIC METHODS
    // ------------------------------------------------------------------------

    public static HTMLTag fromString(String tag) {
        try {
            return HTMLTag.valueOf(tag.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}

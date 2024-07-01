package fr.jwnest.htmlmaker;

import java.util.*;

public enum HTMLTag {
    // MAIN ROOT
    HTML,

    // DOCUMENT METADATA
    BASE,
    HEAD,
    LINK,
    META,
    STYLE,
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
    BLOCKQUOTE,
    DD,
    DIV,
    DL,
    DT,
    FIGCAPTION,
    FIGURE,
    HR,
    LI,
    MENU,
    OL,
    P,
    PRE,
    UL,

    // INLINE TEXT SEMANTICS
    A,
    ABBR,
    B,
    BDI,
    BDO,
    BR,
    CITE,
    CODE,
    DATA,
    DFN,
    EM,
    I,
    KDB,
    MARK,
    Q,
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
    TIME,
    U,
    VAR,
    WBR,

    // IMAGE AND MULTIMEDIA
    AREA,
    AUDIO,
    IMG,
    MAP,
    TRACK,
    VIDEO,

    // EMBEDDED CONTENT
    EMBEDDED,
    IFRAME,
    OBJECT,
    PICTURE,
    PORTAL,
    SOURCE,

    // SVG AND MATHML
    SVG,
    MATH,

    // SCRIPTING
    CANVAS,
    NOSCRIPT,
    SCRIPT,

    // DEMARCATING EDITS
    DEL,
    INS,

    // TABLE CONTENT
    CAPTION,
    COL,
    COLGROUP,
    TABLE,
    TBODY,
    TD,
    TFOOT,
    TH,
    THEAD,
    TR,

    // FORMS
    BUTTON,
    DATALIST,
    FIELDSET,
    FORM,
    INPUT,
    LABEL,
    LEGEND,
    METER,
    OPTGROUP,
    OPTION,
    OUTPUT,
    PROGRESS,
    SELECT,
    TEXTAREA,

    // INTERACTIVE ELEMENTS
    DETAILS,
    DIALOG,
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

package fr.jwnest.htmlmaker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum HTMLAttribute {
    ACCEPT,
    ACCEPT__CHARSET,
    ACCESS_KEY,
    ACTION,
    ALLOW,
    ALT,
    AS,
    ASYNC,
    AUTO_CAPITALIZE,
    AUTO_COMPLETE,
    AUTO_PLAY,
    CAPTURE,
    CHARSET,
    CHECKED,
    CITE,
    CLASS,
    COLS,
    COLSPAN,
    CONTENT,
    CONTENT_EDITABLE,
    CONTROLS,
    COORDS,
    CROSS_ORIGIN,
    CSP,
    DATA,
    DATETIME,
    DECODING,
    DEFAULT,
    DEFER,
    DIR,
    DIRNAME,
    DISABLED,
    DOWNLOAD,
    DRAGGABLE,
    ENCTYPE,
    ENTER_KEY_INT,
    FOR,
    FORM,
    FORM_ACTION,
    FORM_ENCTYPE,
    FORM_METHOD,
    FORM_NOVALIDATE,
    FORM_TARGET,
    HEADERS,
    HIDDEN,
    HIGH,
    HREF,
    HREF_LANG,
    HTTP_EQUIV,
    ID,
    INTEGRITY,
    INTRINSIC_SIZE,
    INPUT_MODE,
    IS_MAP,
    ITEM_PROP,
    KIND,
    LABEL,
    LANG,
    LOADING,
    LIST,
    LOOP,
    LOW,
    MAX,
    MAX_LENGTH,
    MIN_LENGTH,
    MEDIA,
    METHOD,
    MIN,
    MULTIPLE,
    MUTED,
    NAME,
    NO_VALIDATE,
    OPEN,
    OPTIMUM,
    PATTERN,
    PING,
    PLACEHOLDER,
    PLAYS_IN_LINE,
    POSTER,
    PRELOAD,
    READONLY,
    REFERRER_POLICY,
    REL,
    REQUIRED,
    REVERSED,
    ROLE,
    ROWS,
    ROWSPAN,
    SANDBOX,
    SCOPE,
    SELECTED,
    SHAPE,
    SIZE,
    SLOT,
    SPAN,
    SPELLCHECK,
    SRC,
    SRC_DOC,
    SRC_LANG,
    SRC_SET,
    START,
    STEP,
    STYLE,
    SUMMARY,
    TABINDEX,
    TARGET,
    TITLE,
    TRANSLATE,
    TYPE,
    USE_MAP,
    VALUE,
    WIDTH,
    WRAP;


    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------

    public static final Set<HTMLAttribute> GLOBAL_ATTRIBUTES = new HashSet<>(Arrays.asList(
        HTMLAttribute.ACCESS_KEY, HTMLAttribute.AUTO_CAPITALIZE, HTMLAttribute.CLASS, HTMLAttribute.CONTENT_EDITABLE,
        HTMLAttribute.DIR, HTMLAttribute.DRAGGABLE, HTMLAttribute.HIDDEN, HTMLAttribute.ID, HTMLAttribute.ITEM_PROP,
        HTMLAttribute.LANG, HTMLAttribute.ROLE, HTMLAttribute.SLOT, HTMLAttribute.SPELLCHECK, HTMLAttribute.STYLE,
        HTMLAttribute.TABINDEX, HTMLAttribute.TITLE, HTMLAttribute.TRANSLATE
    ));

    // ------------------------------------------------------------------------
    // OVERRIDE METHODS FROM Enum CLASS
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return this.name()
                .toLowerCase()
                .replaceAll("__", "-")
                .replaceAll("_", "");
    }

    // ------------------------------------------------------------------------
    // PUBLIC STATIC METHODS
    // ------------------------------------------------------------------------

    public static HTMLAttribute fromString(String attribute) {
        try {
            return HTMLAttribute.valueOf(attribute
                    .toUpperCase()
                    .replaceAll("-", "__"));

        } catch (IllegalArgumentException e) {
            // can be a special case with one '_' for separated words
            for (HTMLAttribute attr : HTMLAttribute.values()) {
                if (attr.toString().equals(attribute)) {
                    return attr;
                }
            }

            return null;
        }
    }
}

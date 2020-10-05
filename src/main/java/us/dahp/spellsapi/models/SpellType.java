package us.dahp.spellsapi.models;

/**
 * @author sirNikolai
 * @since 04/10/2020
 */
public enum SpellType {

    CHARM("Charm"),
    JINX("Jinx"),
    COUNTER("Counter-Charm"),
    CONJURATION("Conjuration"),
    HEX("Hex"),
    CURSE("Curse"),
    SPELL("Spell"),
    HEALING("Healing"),
    TRANSFIGURATION("Transfiguration");

    private final String camelCase;

    SpellType(String s) {
        this.camelCase = s;
    }

    public String getCamelCase() {
        return camelCase;
    }
}

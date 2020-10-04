package us.dahp.spellsapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import us.dahp.spellsapi.models.AbstractSpell;

/**
 * When a player changes their selected spell.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellSelectionSwitchEvent extends SpellEvent {

    private static final HandlerList handlers = new HandlerList();

    /**
     * Constructor for SpellEvent
     *
     * @param player Player who cast the spell
     * @param spell  The spell that was cast
     */
    public SpellSelectionSwitchEvent(Player player, AbstractSpell spell) {
        super(player, spell);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

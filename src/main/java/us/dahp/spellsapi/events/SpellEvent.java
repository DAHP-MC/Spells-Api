package us.dahp.spellsapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import us.dahp.spellsapi.models.AbstractSpell;

/**
 * Abstract class that is super event of all other spell events.
 * Note: this event <b>will never</b> be explicitly called.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public abstract class SpellEvent extends PlayerEvent {
    private final AbstractSpell spell;

    /**
     * Constructor for SpellEvent
     *
     * @param player Player who cast the spell
     * @param spell  The spell that was cast
     */
    public SpellEvent(Player player, AbstractSpell spell) {
        super(player);
        this.spell = spell;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }

    /**
     * Gets the spell that was used in event
     *
     * @return Spell that was used in event
     */
    public AbstractSpell getSpell() {
        return this.spell;
    }
}
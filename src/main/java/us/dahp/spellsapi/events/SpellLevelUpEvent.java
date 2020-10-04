package us.dahp.spellsapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import us.dahp.spellsapi.models.AbstractSpell;

/**
 * When a player levels up a spell.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellLevelUpEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();

    private final AbstractSpell spell;
    private final int newLevel;

    /**
     * Constructor for SpellLevelUpEvent
     *
     * @param player   Player whose spell leveled up
     * @param spell    The spell that leveled up
     * @param newLevel the new level
     */
    public SpellLevelUpEvent(Player player, AbstractSpell spell, int newLevel) {
        super(player);

        this.spell = spell;
        this.newLevel = newLevel;
    }

    /**
     * Get the spell that leveled up
     *
     * @return Leveled up spell
     */
    public AbstractSpell getSpell() {
        return spell;
    }

    /**
     * Get the new level of the spell
     *
     * @return new level of spell
     */
    public int getNewLevel() {
        return newLevel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

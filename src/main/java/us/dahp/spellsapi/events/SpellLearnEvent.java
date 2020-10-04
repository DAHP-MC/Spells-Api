package us.dahp.spellsapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import us.dahp.spellsapi.models.AbstractSpell;

/**
 * When a user learns a new spell.
 * This will <b>not</b> be called when a player tries to learn a spell thay they already know.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellLearnEvent extends SpellEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean isCanelled;

    /**
     * Constructor for SpellEvent
     *
     * @param player Player who cast the spell
     * @param spell  The spell that is to be learned
     */
    public SpellLearnEvent(Player player, AbstractSpell spell) {
        super(player, spell);
        this.isCanelled = false;
    }

    @Override
    public boolean isCancelled() {
        return isCanelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCanelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

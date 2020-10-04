package us.dahp.spellsapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import us.dahp.spellsapi.models.AbstractSpell;

/**
 * When a player casts a spell.
 * Note: this is called before {@linkplain SpellPostCastEvent}.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellCastEvent extends SpellEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private boolean canceled;

    public SpellCastEvent(Player player, AbstractSpell spell) {
        super(player, spell);
        this.canceled = false;
    }

    public boolean isCancelled() {
        return this.canceled;
    }

    public void setCancelled(boolean cancel) {
        this.canceled = cancel;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

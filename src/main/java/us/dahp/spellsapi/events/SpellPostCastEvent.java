package us.dahp.spellsapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import us.dahp.spellsapi.models.AbstractSpell;

/**
 * After a cast, when durability and spell cast timer taken into account.
 * Note: this is called after {@linkplain SpellCastEvent}.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellPostCastEvent extends SpellEvent {

    private static final HandlerList handlers = new HandlerList();

    public SpellPostCastEvent(Player player, AbstractSpell spell) {
        super(player, spell);
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

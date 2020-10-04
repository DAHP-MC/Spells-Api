package us.dahp.spellsapi.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import us.dahp.spellsapi.models.AbstractSpell;

/**
 * Called when a spell hits a block.
 * Block will be <b>null</b> if it hits a player.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellHitBlockEvent extends SpellEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Block hit;
    private boolean isTimeout;
    private boolean canceled;

    /**
     * Constructor for SpellHitEvent
     *
     * @param player Player who cast spell
     * @param spell  Spell that is cast
     * @param hit    Block that has been affected by the spell
     */
    public SpellHitBlockEvent(Player player, AbstractSpell spell, Block hit) {
        super(player, spell);
        this.hit = hit;
        this.isTimeout = false;
        this.canceled = false;
    }

    /**
     * Get the block that is affected by the spell
     *
     * @return Block affected by spell
     */
    public Block getHitBlock() {
        return hit;
    }

    /**
     * If the event was called from being timed out
     *
     * @return if event was from timeout
     */
    public boolean isTimeout() {
        return isTimeout;
    }

    /**
     * Set if the event was called from a timeout
     *
     * @param isTimeout if event was from timeout
     */
    public void setTimeout(boolean isTimeout) {
        this.isTimeout = isTimeout;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.canceled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

package us.dahp.spellsapi.events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import us.dahp.spellsapi.models.AbstractSpell;

import java.util.List;

/**
 * When a spell hits an entity.
 * Entities will be null if it hits a block.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public class SpellHitEntityEvent extends SpellEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private List<? extends LivingEntity> hit;
    private boolean canceled;

    /**
     * Constructor for SpellHitEntityEvent
     *
     * @param player Player who cast spell
     * @param spell  Spell that is cast
     * @param hit    Entities that have been affected by the spell
     */
    public SpellHitEntityEvent(Player player, AbstractSpell spell, List<? extends LivingEntity> hit) {
        super(player, spell);
        this.hit = hit;
        this.canceled = false;
    }

    /**
     * Get the entities that are affected by the spell
     *
     * @return Entities affected by spell
     */
    public List<? extends LivingEntity> getHitEntites() {
        return this.hit;
    }

    /**
     * Sets entities to be hit by spell
     *
     * @param hit Entities that are to be hit by the spell
     */
    public void setHitEntities(List<? extends LivingEntity> hit) {
        this.hit = hit;
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

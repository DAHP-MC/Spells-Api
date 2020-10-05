package us.dahp.spellsapi.models;

import org.bukkit.Location;

/**
 * Controls spell effects. What happens while spell is traveling, and finishes journey.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public abstract class AbstractSpellEffect {

    /**
     * Method called whenever a spell updates its position.
     * Period can be considered one tick. First iteration starts at 0.
     *
     * @param startLocation Location where spell was originally casted from.
     * @param endLocation   The current location of the spell.
     * @param period        What iteration the spell is in the trail.
     */
    public abstract void renderTrail(Location startLocation, Location endLocation, long period);

    /**
     * Called when the spell makes contact with block/entity/times out
     *
     * @param startLocation The starting location from where the spell started.
     * @param endLocation   The center location for the effect to play out.
     */
    public abstract void renderEnd(Location startLocation, Location endLocation);
}

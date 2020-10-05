package us.dahp.spellsapi.models;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * General spell class. This should be extended when creating a spell that casts at around the caster to surrounding entities.
 * Class will only call {@link AbstractSpell#impactEntities(Player, float, List)}, never block.
 *
 * @author sirNikolai
 * @since 05/10/2020
 */
public abstract class AbstractSurroundSpell extends AbstractSpell {

    private final int radius;

    public AbstractSurroundSpell(
                                 String name,
                                 SpellType type,
                                 AbstractSpellEffect spellEffect,
                                 SpellDescription description,
                                 List<String> commands,
                                 int durability,
                                 int maxAffectedEntities,
                                 long castTime,
                                 int radius) {
        super(name, type, spellEffect, description, commands, durability, maxAffectedEntities, castTime);

        this.radius = radius;
    }

    @Override
    public void impactBlock(Player caster, float multiplier, Block targetBlock) {}

    /**
     * Retrieves the block radius that the spell applies to.
     * This is the base radius and may change in impact depending on multiplier if used.
     *
     * @return block radius for spell usage.
     */
    public int getRadius() {
        return radius;
    }
}

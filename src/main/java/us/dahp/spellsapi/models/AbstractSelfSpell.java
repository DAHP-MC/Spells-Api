package us.dahp.spellsapi.models;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * General spell class. This should be extended when creating a spell that casts at the caster.
 * Class will only call {@link AbstractSpell#impactEntities(Player, float, List)}, never block.
 *
 * @author sirNikolai
 * @since 05/10/2020
 */
public abstract class AbstractSelfSpell extends AbstractSpell {

    public AbstractSelfSpell(
            String name,
            SpellType type,
            AbstractSpellEffect spellEffect,
            SpellDescription description,
            List<String> commands,
            int durability,
            int maxAffectedEntities,
            long castTime) {
        super(name, type, spellEffect, description, commands, durability, maxAffectedEntities, castTime);
    }

    @Override
    public void impactBlock(Player caster, float multiplier, Block targetBlock) {}
}

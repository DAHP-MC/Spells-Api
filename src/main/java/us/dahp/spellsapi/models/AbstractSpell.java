package us.dahp.spellsapi.models;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * General spell class. This should be extended when creating a standard spell that casts at a target.
 *
 * @author sirNikolai
 * @since 04/10/2020
 */
public abstract class AbstractSpell {

    private final String name;
    private final SpellType type;

    private final List<String> description;
    private final List<String> commands;

    private final int durability;
    private final int maxAffectedEntities;

    private final long castTime;

    public AbstractSpell(
            String name,
            SpellType type,
            List<String> description,
            List<String> commands,
            int durability,
            int maxAffectedEntities,
            long castTime) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.commands = commands;
        this.durability = durability;
        this.maxAffectedEntities = maxAffectedEntities;
        this.castTime = castTime;
    }

    /**
     * Called when spell hits entities
     *
     * @param caster     Player who cast the spell
     * @param multiplier the spell multiplier
     * @param entities   Entities affected by spell
     */
    public void impact(Player caster, float multiplier, LivingEntity... entities) {
        this.impact(caster, multiplier, Arrays.asList(entities));
    }

    /**
     * Called when spell hits entities
     *
     * @param caster     Player who cast the spell
     * @param multiplier the spell multiplier
     * @param entities   Entities affected by spell
     */
    public abstract void impact(Player caster, float multiplier, List<LivingEntity> entities);

    public String getName() {
        return name;
    }

    public SpellType getType() {
        return type;
    }

    public List<String> getDescription() {
        return Collections.unmodifiableList(description);
    }

    public List<String> getCommands() {
        return Collections.unmodifiableList(commands);
    }

    public int getDurability() {
        return durability;
    }

    public int getMaxAffectedEntities() {
        return maxAffectedEntities;
    }

    public long getCastTime() {
        return castTime;
    }
}

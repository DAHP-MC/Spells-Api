package us.dahp.spellsapi.models;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Standardized spell description model.
 *
 * @author sirNikolai
 * @since 05/10/2020
 */
public class SpellDescription {

    private String pronounciation;

    private SpellType spellType;

    private int damage;

    private long cooldown;

    private int durability;

    private List<String> description;

    public SpellDescription(String pronounciation, SpellType spellType, int damage, long cooldown, int durability, List<String> description) {
        this.pronounciation = pronounciation;
        this.spellType = spellType;
        this.damage = damage;
        this.cooldown = cooldown;
        this.durability = durability;
        this.description = description;
    }

    /**
     * Returns list of strings in the correct format for usage in game.
     *
     * @return List of formatted strings.
     */
    public List<String> generateLore() {
        List<String> lore = new ArrayList<>();


        lore.add(ChatColor.translateAlternateColorCodes('&', String.format("&e(%s)", pronounciation)));
        lore.add(ChatColor.translateAlternateColorCodes('&', String.format("&7Type: &8%s", spellType.getCamelCase())));
        lore.add(ChatColor.translateAlternateColorCodes('&', String.format("&cDamage: &4%s", getHearts())));
        lore.add(ChatColor.translateAlternateColorCodes('&', String.format("&dCooldown: &5%d", cooldown)));
        lore.add(ChatColor.translateAlternateColorCodes('&', String.format("&2Durability: &a%d", durability)));
        lore.add("");

        lore.addAll(description.stream().map(s -> ChatColor.translateAlternateColorCodes('&', s)).collect(Collectors.toList()));

        return lore;
    }

    private String getHearts() {
        if(damage <= 0) {
            return "None";
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < damage; i++) {
            sb.append("\u2665");
        }

        return sb.toString();
    }
}

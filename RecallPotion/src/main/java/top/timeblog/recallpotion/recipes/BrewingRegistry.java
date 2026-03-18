package top.timeblog.recallpotion.recipes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import io.papermc.paper.potion.PotionMix;
import org.bukkit.potion.PotionType;


public class BrewingRegistry {
    private final JavaPlugin plugin;
    public BrewingRegistry(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * 注册所有的自定义酿造配方
     */
    public void registerRecipes() {
        registerThickToCustomHealing();
    }

    private void registerThickToCustomHealing() {
        ItemStack result = new ItemStack(Material.POTION);
        PotionMeta resultMeta = (PotionMeta) result.getItemMeta();

        if (resultMeta != null) {
            resultMeta.setColor(Color.fromRGB(3341564));
            resultMeta.setEnchantmentGlintOverride(true);
            Component displayName = LegacyComponentSerializer.legacySection().deserialize("§3回忆药水");
            resultMeta.setBasePotionType(PotionType.AWKWARD);
            resultMeta.displayName(displayName);
            result.setItemMeta(resultMeta);
        }

        ItemStack thickPotion = new ItemStack(Material.POTION);
        PotionMeta thickMeta = (PotionMeta) thickPotion.getItemMeta();
        if (thickMeta != null) {
            thickMeta.setBasePotionType(PotionType.THICK);
            thickPotion.setItemMeta(thickMeta);
        }
        RecipeChoice inputChoice = new RecipeChoice.ExactChoice(thickPotion);

        RecipeChoice ingredientChoice = new RecipeChoice.MaterialChoice(Material.ECHO_SHARD);

        // 注册配方
        NamespacedKey key = new NamespacedKey(plugin, "thick_to_custom_healing");
        PotionMix potionMix = new PotionMix(key, result, inputChoice, ingredientChoice);
        Bukkit.getPotionBrewer().addPotionMix(potionMix);
    }
}
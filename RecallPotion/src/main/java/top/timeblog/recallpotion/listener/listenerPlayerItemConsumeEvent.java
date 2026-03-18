package top.timeblog.recallpotion.listener;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

public class listenerPlayerItemConsumeEvent implements Listener {
    @EventHandler
    public void onItemConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item.getType() == Material.POTION) {
            PotionMeta meta = (PotionMeta) item.getItemMeta();
            if (meta != null) {
                // 检测自定义颜色
                Color color = meta.getColor();
                if (color != null && color.asRGB() == 3341564) {
                    if (meta.getEnchantmentGlintOverride()) {
                        player.playSound(player.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.4f, 1.0f);
                        Location respawnLocation = player.getBedSpawnLocation();
                        if (respawnLocation != null) {
                            player.teleport(respawnLocation);
                        } else {
                             respawnLocation = event.getPlayer().getServer().getRespawnWorld().getSpawnLocation();
                            player.teleport(respawnLocation);
                        }
                    }
                }
            }
        }
    }
}

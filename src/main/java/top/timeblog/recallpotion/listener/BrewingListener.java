package top.timeblog.recallpotion.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BrewingStartEvent;
import org.bukkit.inventory.ItemStack;

public class BrewingListener implements Listener {

    @EventHandler
    public void onBrewingStart(BrewingStartEvent event) {
        ItemStack ingredient = event.getSource();
        if (ingredient.getType() != Material.ECHO_SHARD) return;
        event.setBrewingTime(2400);
    }
}
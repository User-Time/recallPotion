package top.timeblog.recallpotion;

import org.bukkit.plugin.java.JavaPlugin;
import top.timeblog.recallpotion.listener.BrewingListener;
import top.timeblog.recallpotion.listener.listenerPlayerItemConsumeEvent;
import top.timeblog.recallpotion.recipes.BrewingRegistry;

public final class recallPotion extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        BrewingRegistry brewingRegistry = new BrewingRegistry(this);
        brewingRegistry.registerRecipes();


        getServer().getPluginManager().registerEvents(new listenerPlayerItemConsumeEvent(), this);
        getServer().getPluginManager().registerEvents(new BrewingListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

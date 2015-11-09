package me.thenander.slimegrenades;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


public class SlimeGrenades extends JavaPlugin implements Listener {

    public final Logger logger = Logger.getLogger("Minecraft");

    public void onEnable() {
        
        PluginDescriptionFile pdf = getDescription();

        getLogger().info("SlimeGrenades " + pdf.getVersion() + " has been enabled!");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public void onDisable() {
        
        PluginDescriptionFile pdf = getDescription();

        getLogger().info("SlimeGrenades " + pdf.getVersion() + " has been disabled!");
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void OnPlayerDrop(ItemSpawnEvent e) {
        
        getLogger().info("Item dropped! Is it a slimeball?");
        Item ball = e.getEntity();
        ItemStack istack = ball.getItemStack();

        if (istack.getType() == Material.SLIME_BALL) {
            getLogger().info("The item dropped is a slimeball! Commence explosion in 60 ticks!");

            BukkitTask localBukkitTask = new ExplosiveTask(ball).runTaskLater(this, 60L);
        }
    }
}

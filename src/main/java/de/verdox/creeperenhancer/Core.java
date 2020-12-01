package de.verdox.creeperenhancer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {

    private Settings settings;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);
        this.settings = new Settings(this,"config.yml","\\");
        this.settings.init();
    }

    @EventHandler
    public void explode(EntityExplodeEvent e){
        if(!(e.getEntity() instanceof Creeper))
            return;
        Creeper creeper = (Creeper) e.getEntity();
    }

    @EventHandler
    public void explosion(ExplosionPrimeEvent e){
        if(!(e.getEntity() instanceof Creeper))
            return;
        e.setRadius(this.settings.getRadius());
    }
}

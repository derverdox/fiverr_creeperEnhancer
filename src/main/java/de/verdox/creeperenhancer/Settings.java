package de.verdox.creeperenhancer;

import de.verdox.vcore.files.Configuration;
import org.bukkit.plugin.Plugin;

public class Settings extends Configuration {
    public Settings(Plugin plugin, String fileName, String pluginDirectory) {
        super(plugin, fileName, pluginDirectory);
    }

    @Override
    public void setupConfig() {
        config.addDefault("CreeperRadius",20);
        config.options().copyDefaults(true);
        save();
    }

    public int getRadius(){
        return config.getInt("CreeperRadius");
    }

}

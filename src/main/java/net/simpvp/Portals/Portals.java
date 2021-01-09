package net.simpvp.Portals;

import java.io.File;
import java.util.UUID;
import java.util.HashSet;

import org.bukkit.plugin.java.JavaPlugin;

public class Portals extends JavaPlugin {

	public static JavaPlugin instance;

	public static HashSet<UUID> justTeleportedEntities = new HashSet<UUID>();

	public void onEnable() {
		instance = this;

		/* Check if this plugin's directory exists, if not create it */
		File dir = new File("plugins/Portals");
		if ( !dir.exists() ) {
			dir.mkdir();
		}

		getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		getServer().getPluginManager().registerEvents(new BlockPlace(), this);
		getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
		getServer().getPluginManager().registerEvents(new PlayerToggleSneak(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteract(), this);

		SQLite.connect();
	}

	public void onDisable() {
		SQLite.close();
	}


}

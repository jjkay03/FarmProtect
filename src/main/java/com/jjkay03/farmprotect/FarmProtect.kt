package com.jjkay03.farmprotect

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityInteractEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

class FarmProtect : JavaPlugin(), Listener {

    // Plugin startup logic
    override fun onEnable() {
        // Register events
        server.pluginManager.registerEvents(this, this)
    }

    // Protect from mobs
    @EventHandler
    fun onEntityInteract(event: EntityInteractEvent) {
        if (event.block.type == Material.FARMLAND) {
            event.isCancelled = true
        }
    }

    // Protect from players
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        if (event.action == Action.PHYSICAL && event.clickedBlock?.type == Material.FARMLAND) {
            event.isCancelled = true
        }
    }

    // Plugin shutdown logic
    override fun onDisable() {}
}

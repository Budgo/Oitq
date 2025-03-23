package me.aroze.oitq.listeners

import me.aroze.oitq.user.UserManager.user
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

object QuitListener : Listener {

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        event.player.user.killStreak = 0

        // I'm in a weird halfway point where, currently, K/D stats are saved persistently
        // until the server ends. If this plugin ever gets put into something more
        // permanent, we should pick one and roll with it.
    }
}
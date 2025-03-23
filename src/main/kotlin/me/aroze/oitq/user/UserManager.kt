package me.aroze.oitq.user

import org.bukkit.entity.Player
import java.util.UUID

object UserManager {
    private val users = mutableMapOf<UUID, User>()

    private fun initializeUser(player: Player): User {
        val user = User()
        users[player.uniqueId] = user

        return user
    }

    // TODO: fix memory leak

    val Player.user: User
        get() = users[this.uniqueId] ?: initializeUser(this)

}

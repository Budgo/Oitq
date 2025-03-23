package me.aroze.oitq.util

import me.aroze.oitq.user.User
import org.bukkit.Sound

object KillStreakUtil {

    private val killStreakPalettes = listOf(
        KillStreakPalette("kill-tastic", "<#ffd3b3>", "<#ff994f>", "<#e3ccba>", Sound.ENTITY_IRON_GOLEM_REPAIR),
        KillStreakPalette("bloodlusted", "<#fff2b3>", "<#ffea4f>", "<#e3ddba>", Sound.ENTITY_WITHER_BREAK_BLOCK),
        KillStreakPalette("rampaging",   "<#dfffb3>", "<#9bff4f>", "<#cfe3ba>", Sound.ENTITY_GHAST_SCREAM),
        KillStreakPalette("unstoppable", "<#b3ffed>", "<#4fedff>", "<#bae3e0>", Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR),
        KillStreakPalette("horrifying",  "<#b3deff>", "<#4f9bff>", "<#bacae3>", Sound.ENTITY_BLAZE_DEATH),
        KillStreakPalette("godly",       "<#ceb3ff>", "<#904fff>", "<#cfbae3>", Sound.ENTITY_WITHER_AMBIENT)
    )

    // TODO: killstreak-ending method (used for both death and quitting)

    private fun getKillStreakTier(user: User): Int {
        val kills = user.killStreak.toDouble()
        return ((kills / 5.0).coerceAtMost(killStreakPalettes.size.toDouble())).toInt()
    }

    fun getUserKillStreakPalette(user: User): KillStreakPalette {
        val tier = getKillStreakTier(user)
        return killStreakPalettes[tier - 1]
    }

}

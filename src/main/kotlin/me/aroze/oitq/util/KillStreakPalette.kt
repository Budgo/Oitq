package me.aroze.oitq.util

import org.bukkit.Sound

data class KillStreakPalette(
    val name: String,
    val color: String,
    val iconColor: String,
    val accentColor: String,
    val sound: Sound,

    ) {
    val formattedName: String
        get() = "<b>${color}${name.uppercase()}"
}

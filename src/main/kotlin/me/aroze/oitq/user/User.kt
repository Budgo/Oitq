package me.aroze.oitq.user

data class User(
    var killStreak: Int = 0,
    var kills: Int = 0,
    var deaths: Int = 0,
    var scoreboard: FastBoard

) fun updateScoreboard() {

}

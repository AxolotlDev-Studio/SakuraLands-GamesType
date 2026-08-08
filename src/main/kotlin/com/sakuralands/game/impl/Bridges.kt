package com.sakuralands.game.impl

import com.sakuralands.game.FourPlayer
import com.sakuralands.game.MultiPlayerGame
import com.sakuralands.game.TwoPlayer

sealed interface Bridge : MultiPlayerGame

sealed class TwoTeamBridge(
  val id: String,
  override val assets: String,
  override val map: String,
) : Bridge, TwoPlayer {
  override val namespace: String
    get() = "${super.namespace}:game:bridge:two:$id"
  override val playerCount: IntRange
    get() = 2..2
}

sealed class FourTeamBridge(
  val id: String,
  override val assets: String,
  override val map: String,
) : Bridge, FourPlayer {
  override val namespace: String
    get() = "${super.namespace}:game:bridge:four:$id"
  override val playerCount: IntRange
    get() = 2..4
}

object RomanTwoBridge: TwoTeamBridge("roman", "bridge_roman_2.bin", "bridge_roman_2.tar.gz")
object RomanFourBridge: FourTeamBridge("roman", "bridge_roman_4.bin", "bridge_roman_4.tar.gz")

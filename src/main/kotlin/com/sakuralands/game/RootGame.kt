package com.sakuralands.game

sealed interface Game {
  val namespace: String get() = "sakuralands"
  val assets: String
  val playerCount: IntRange
  val map: String
}

interface SinglePlayerGame: Game, OnePlayer {
  override val playerCount: IntRange get() = 1 .. 1
}

interface MultiPlayerGame: Game
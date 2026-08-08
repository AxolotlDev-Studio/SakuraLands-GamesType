@file:Suppress("TestFunctionName")

package com.sakuralands.com.sakuralands.game

import com.sakuralands.game.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BasicGameTest {
  @Test
  fun RequiredNotEmpty() {
    assertFalse(ALL_GAMES.isEmpty())
  }

  @Test
  fun GamePlayersCountMustBePositive() {
    assertTrue(ALL_GAMES.all { game -> game.playerCount.first >= 1 && game.playerCount.last >= 1 })
  }

  @Test
  fun SinglePlayerGameCannotBeMoreThanOnePlayer() {
    val games = ALL_GAMES.filterIsInstance<SinglePlayerGame>()
    assertTrue(games.all { game -> game.playerCount.first == 1 && game.playerCount.last == 1 })
  }

  @Test
  fun MultiPlayerGameCannotBeOnePlayer() {
    val games = ALL_GAMES.filterIsInstance<MultiPlayerGame>()
    assertFalse(games.any { game -> game.playerCount.first == 1 && game.playerCount.last == 1 })
  }

  @Test
  fun SinglePlayerGameOnlyCanBeSubClassOfOnePlayer() {
    val games = ALL_GAMES.filterIsInstance<SinglePlayerGame>()
    assertFalse(games.any { game -> game is TwoPlayer || game is FourPlayer })
  }

  @Test
  fun UniqueNameSpace() {
    val namespaces = ALL_GAMES.map { it.namespace }
    val duplicates = namespaces.groupBy { it }.filter { it.value.size > 1 }.keys
    assertTrue(duplicates.isEmpty(), "Namespace cannot be duplicate: $duplicates")
  }

  @Test
  fun AssetsAndMapReady() {
    ALL_GAMES.forEach { game ->
      val usable = runCatching {
        game.assets
        game.map
        true
      }.getOrElse {
        if (it is NotImplementedError) { // Cannot be TODO()
          false
        } else throw it
      }
      assertTrue(usable)
    }
  }

}
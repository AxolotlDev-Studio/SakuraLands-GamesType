# SakuraLands-GamesType

## List all games in SakuraLands, for Java/Kotlin (Re-)Serialization for API Call.

### Please read [LICENSE](LICENSE) file before use it.

## Propose a Game
**You may not send a pull request or open an issue, all pull request from non-studio members will be rejected.**

If you want to propose a game, please use [this form](https://go.sakuralands.com/propose-a-game)

## How to use

1. Import AxolotlDev Studio's official SakuraLands repository.

**Maven**
```xml
<repositories>
    <repository>
        <id>axolotldev-studio-sakuralands</id>
        <name>AxolotlDev Studio SakuraLands Repository Server</name>
        <url>https://repo.axolotldev.me/repository/sakuralands/</url>
    </repository>
</repositories>
```
**Gradle (Groovy DSL)**
```groovy
repositories {
    mavenCentral()
    maven {
        url "https://repo.axolotldev.me/repository/sakuralands/"
    }
}
```
**Gradle (Kotlin DSL)**
```kotlin
repositories {
  mavenCentral()
  maven("https://repo.axolotldev.me/repository/sakuralands/")
}
```

2. Import SakuraLands-GamesType

**Maven**
```xml
<dependency>
    <groupId>com.sakuralands.game</groupId>
    <artifactId>GamesType</artifactId>
    <version>LATEST</version>
</dependency>
```
**Gradle (Groovy DSL)**
```groovy
implementation 'com.sakuralands.game:GamesType:latest.release'
```
**Gradle (Kotlin DSL)**
```kotlin
implementation("com.sakuralands.game:GamesType:latest.release")
```

> ## Please keep it latest, API endpoint WILL NOT be backward compatibility.

## Example

### 1. Get all single player game

**Java**
```java
final List<Game> singlePlayerGames = AllGamesKt.getALL_GAMES().stream().filter(game -> game instanceof SinglePlayerGame).toList();
```
**Kotlin**
```kotlin
val singlePlayerGames = ALL_GAMES.filterIsInstance<SinglePlayerGame>()
```

### 2. Check if this object is a game 

**Java**
```java
public static boolean isGame(Object o) {
 return o instanceof Game; 
}
```
**Kotlin**
```kotlin
fun isGame(any: Any) = any is Game 
```

### 3. Counting how many BedWar map

**Java**
```java
final int games = AllGamesKt.getALL_GAMES().stream().filter(game -> game instanceof Bridge).map(Game::getMap).collect(Collectors.toSet()).size();
```
**Kotlin**
```kotlin
val count = ALL_GAMES.filterIsInstance<BedWar>().map { game -> game.map }.toSet().size
```

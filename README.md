# DKCoins - Minecraft CoinSystem

## Installation 

### Spigot

 1. Download the current version from SpigotMC.
 2. Put the plugin in your spigot plugin folder.
 3. Restart your server.
 4. Select a storage type (More informations below).
 5. restart your server.

### BungeeCord

The BungeeCord plugin is only a API, it has no commands.This is very interesting when you have a BungeeCord plugin, which needs Coins.

 1. Download the current version from SpigotMC.
 2. Put the plugin in your BungeeCord plugin folder.
 3. Restart your server.
 4. Select a storage type (Use the same storage and database, then your spigot server. BungeeCord has no json support).
 5. restart your server.

## Storage

There are four storage options, json is not supported for BungeeCord.

### SQLite

```java
storage:
  folder: plugins/DKCoins/data/
  type: SQLITE
  host: localhost
  port: '3306'
  user: root
  password: YourPassword
  database: DKCoins
  mongodb:
    mongodbauthentication: true
    authenticationDatabase: test
    srv: true
```

### MySQL

Replace the password and user to your data.

```java
storage:
  folder: plugins/DKCoins/data/
  type: MYSQL
  host: localhost
  port: '3306'
  user: root
  password: YourPassword
  database: DKCoins
  mongodb:
    mongodbauthentication: true
    authenticationDatabase: test
    srv: true
```

## Developer (API usage)

### Get a CoinPlayer

```java
//by ID
CoinPlayer player = CoinSystem.getInstance().getPlayerManager().getPlayer(int id);

//by UUID
CoinPlayer player = CoinSystem.getInstance().getPlayerManager().getPlayer(UUID uuid);

//by Name
CoinPlayer player = CoinSystem.getInstance().getPlayerManager().getPlayer(String name);
```

### Get player informations

```java
player.getName(); //returns the player name

player.getUUID(); //returns the player uuid

player.getID(); //returns the player id

player.getCoins(); //returns the coins amount

player.getColor(); //returns the player color

player.getFirstLogin(); //returns the first login as timestamp

player.getLastLogin(); //returns the last login as timestamp

```

### set, add or remove coins from a player
```java
player.setCoins(long coins);

player.setCoins(long coins, CoinsUpdateCause cause);

player.setCoins(long coins, String message);

player.setCoins(long coins, CoinsUpdateCause cause, String message);
```

Set,  remove and add have the same methodes.

```java
player.addCoins(long coins);
player.removeCoins(long coins);
```

The CoinsUpdateCause and message is to identify the coin change in the event.

Available CoinsUpdateCause
 * ADMIN
 * API
 * PAY

### Event

#### ProxiedCoinPlayerCoinsChangeEvent / BukkitCoinPlayerCoinsChangeEvent

Use the event as normal Bukkit or BungeeCord event.

Event options
```java
event.getCoinPlayer(); // get the player

event.getCause(); //get the update cause

event.getMessage(); //get the update message

event.getOldCoins(); //get the coins before the change

event.getNewCoins(); //get the new coin amount

event.isCancelled(); //check if the event is cancelled

event.setCancelled(boolean cancel); //cancel the event

event.setCoins(long coins); //set the new coin amount.
```

#### ProxiedCoinPlayerColorSetEvent / BukkitCoinPlayerColorSetEvent

Use the event as normal Bukkit or BungeeCord event.
The event will be executed, when the player gets a color

Event options
```java
event.getPlayer(); // get the player

event.getColor(); //get the update cause
```

## License

This project is licensed under the Apache License - see the [LICENSE](LICENSE) file for more informations.

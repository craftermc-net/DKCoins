package ch.dkrieger.coinsystem.core;

import ch.dkrieger.coinsystem.core.event.CoinChangeEventResult;
import ch.dkrieger.coinsystem.core.event.CoinsUpdateCause;
import ch.dkrieger.coinsystem.core.player.CoinPlayer;

import java.io.File;

public interface DKCoinsPlatform {

    String getPlatformName();

    String getServerVersion();

    File getFolder();

    String getColor(CoinPlayer player);

    CoinChangeEventResult executeCoinChangeEvent(CoinPlayer player, long oldCoins, long newCoins, CoinsUpdateCause cause, String message);
}

package me.gonkas.zombieplayers.util;

import net.minecraft.util.Identifier;
import static me.gonkas.zombieplayers.ZombiePlayers.MODID;

public class ZombiePlayersIdentifier {

    public static Identifier of(String name) {
        return Identifier.of(MODID, name);
    }
}

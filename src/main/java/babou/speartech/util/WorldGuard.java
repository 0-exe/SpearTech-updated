package babou.speartech.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

/**
 * Central environment check used by gameplay-changing modules.
 */
public final class WorldGuard {
    private WorldGuard() {
    }

    /**
     * Returns true when the client is connected to a world and can apply
     * client-side gameplay modifications to its local player.
     */
    public static boolean canModifyGameplay() {
        Minecraft mc = Minecraft.getInstance();

        return mc.player != null && mc.level != null && mc.getConnection() != null;
    }

    /**
     * Returns true only for the local player while gameplay modification is allowed.
     */
    public static boolean isOwnedPlayer(Player player) {
        Minecraft mc = Minecraft.getInstance();

        return canModifyGameplay()
            && mc.player != null
            && player.getUUID().equals(mc.player.getUUID());
    }
}

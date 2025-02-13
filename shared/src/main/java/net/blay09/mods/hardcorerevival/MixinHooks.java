package net.blay09.mods.hardcorerevival;

import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

public class MixinHooks {

    public static boolean shouldCancelMovement(Entity entity) {
        return entity instanceof Player && HardcoreRevival.getRevivalData(entity).isKnockedOut();
    }

    public static boolean shouldCancelAttackTarget(@Nullable LivingEntity attacker, LivingEntity target) {
        return target instanceof Player && HardcoreRevival.getRevivalData(target).isKnockedOut();
    }

    public static boolean shouldCancelHealing(Player entity) {
        return HardcoreRevival.getRevivalData(entity).isKnockedOut();
    }

    public static void handleProcessPlayerRotation(ServerPlayer player, ServerboundMovePlayerPacket packet) {
        float yaw = packet.getYRot(player.getYRot());
        float pitch = packet.getXRot(player.getXRot());
        player.absMoveTo(player.getX(), player.getY(), player.getZ(), yaw, pitch);
    }
}

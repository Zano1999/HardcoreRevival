package net.blay09.mods.hardcorerevival.mixin;

import net.blay09.mods.hardcorerevival.FabricPlayer;
import net.blay09.mods.hardcorerevival.capability.HardcoreRevivalData;
import net.blay09.mods.hardcorerevival.capability.HardcoreRevivalDataImpl;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Player.class)
public class FabricPlayerMixin implements FabricPlayer {

    private HardcoreRevivalData hardcoreRevivalData;

    @Override
    public HardcoreRevivalData getHardcoreRevivalData() {
        if(hardcoreRevivalData == null) {
            hardcoreRevivalData = new HardcoreRevivalDataImpl();
        }
        return hardcoreRevivalData;
    }

}

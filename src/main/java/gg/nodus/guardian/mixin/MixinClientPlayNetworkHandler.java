package gg.nodus.guardian.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.chat.MessageSignature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientPacketListener.class)
public class MixinClientPlayNetworkHandler {

    /**
     * LMFAO
     */
    // TODO: Verify is the yarn->mojang translation correct
    @ModifyVariable(method = "markMessageAsProcessed", at = @At("HEAD"), argsOnly = true, index = 2)
    public boolean acknowledge(MessageSignature message, boolean value) {
        return message.getSender().equals(Minecraft.getInstance().player.getUuid());
    }

}

package gg.nodus.guardian.mixin;

import com.mojang.authlib.GameProfile;

import java.time.Instant;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.chat.ChatListener;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MessageSignature;
import net.minecraft.network.chat.PlayerChatMessage;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatListener.class)
public class MixinClientPlayNetworkHandler {

    /**
     * LMFAO
     */
    // TODO: Verify is the yarn->mojang translation correct
    @Inject(method = "showMessageToPlayer", at = @At("RETURN"), cancellable = true)
    public void acknowledge(ChatType.Bound bound, PlayerChatMessage message, Component component, GameProfile gameProfile, boolean bl, Instant instant, CallbackInfoReturnable<Boolean> ci) {
        ci.setReturnValue(message.sender().equals(Minecraft.getInstance().player.getUUID()));
    }

}

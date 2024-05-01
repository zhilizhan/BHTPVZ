package com.zhilizhan.bhtpvz.common.mixin;

import com.zhilizhan.bhtpvz.BHTPvZ;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(Level.class)
public class LevelMixin{
    @Inject(method = "getDayTime", at = @At("HEAD"), cancellable = true)
    public void getDayTime(CallbackInfoReturnable<Long> cir) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            Biome biome = this.getSelf().getBiome(player.blockPosition());
            boolean flag = Objects.equals(biome.getRegistryName(), new ResourceLocation(BHTPvZ.MOD_ID, "night"));
            if (flag) {
                cir.setReturnValue(18000L);
            }
        }
    }
    @Inject(method = "isDay", at = @At("HEAD"), cancellable = true)
    public void isDay(CallbackInfoReturnable<Boolean> cir) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            Biome biome = this.getSelf().getBiome(player.blockPosition());
            boolean flag = Objects.equals(biome.getRegistryName(), new ResourceLocation(BHTPvZ.MOD_ID, "night"));
            if (flag) {
                cir.setReturnValue(false);
            }
        }
    }
    @Unique
    private Level getSelf() {
        return (Level) (Object) this;
    }
}

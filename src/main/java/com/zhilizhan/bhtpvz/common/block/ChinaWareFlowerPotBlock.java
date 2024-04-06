package com.zhilizhan.bhtpvz.common.block;

import com.hungteen.pvz.common.block.special.FlowerPotBlock;
import com.hungteen.pvz.common.misc.sound.SoundRegister;
import com.zhilizhan.bhtpvz.common.item.BHTPvZItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ChinaWareFlowerPotBlock extends FlowerPotBlock {
    private final Minecraft minecraft = Minecraft.getInstance();
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (player.getMainHandItem().getItem()== BHTPvZItems.HAMMER.get()) {
            level.removeBlock(pos, false);
           if (!player.isCreative()) {
                player.getCooldowns().addCooldown(BHTPvZItems.HAMMER.get(), 30);
               if(player instanceof ServerPlayer)player.getMainHandItem().hurt(5,level.random, (ServerPlayer) player);
           }
           player.level.playSound(null, player.blockPosition(), SoundRegister.HAMMER_BONK.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
           this.playDelaySound(pos.getX(),pos.getY(),pos.getZ(), SoundRegister.VASE_BREAKING.get(), SoundSource.BLOCKS, 1.0F, 1.0F);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
    public void playDelaySound(double x, double y, double z, SoundEvent sound, SoundSource category, float volume, float pitch) {
        SimpleSoundInstance simplesound = new SimpleSoundInstance(sound, category, volume, pitch, x, y, z);
        this.minecraft.getSoundManager().playDelayed(simplesound, (int)(20.0));
    }

}

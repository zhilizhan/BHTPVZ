package com.zhilizhan.bhtpvz.common.entity.misc;

import com.hungteen.pvz.common.capability.CapabilityHandler;
import com.hungteen.pvz.common.entity.misc.drop.SunEntity;
import com.hungteen.pvz.utils.EntityUtil;
import com.hungteen.pvz.utils.PlayerUtil;
import com.hungteen.pvz.utils.enums.Resources;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RedSunEntity extends SunEntity {
    public RedSunEntity(EntityType<? extends Mob> type, Level worldIn) {
        super(type, worldIn);
        this.setAmount(this.getDefaultAmount());
        this.setNoGravity(true);
    }
    public Vec3 ColorBase = new Vec3(240.0, 24.0, 24.0);
    @Override
    protected int getDefaultAmount() {
        return -50;
    }
    public int getIcon() {
        int value = -(this.getAmount());
        return value < 6 ? 0 : (value < 16 ? 1 : (value < 26 ? 2 : 3));
    }
    public void tick() {
        super.tick();
        if ((this.tickCount + this.getId()) % 40 == 0) {
            Entity following = this.level.getNearestPlayer(this, 32.0);
            if (following instanceof Player player&&EntityUtil.isEntityValid(player)) {
                this.giveSunToTarget(player);
            }
        }
    }
    private void giveSunToTarget(Player player) {
        if (!level.isClientSide) {
            player.getCapability(CapabilityHandler.PLAYER_DATA_CAPABILITY).ifPresent((l) -> {
                int amount = this.getAmount();
                {
                    l.getPlayerData().addResource(Resources.SUN_NUM, amount);
                    PlayerUtil.playClientSound(player, SoundEvents.PLAYER_HURT_ON_FIRE);
                }
            });
        }

    }
}
package com.zhilizhan.bhtpvz.common.entity.bullet;

import com.hungteen.pvz.common.entity.bullet.AbstractBulletEntity;
import com.hungteen.pvz.utils.WorldUtil;
import com.zhilizhan.bhtpvz.client.particle.BHTPvZParticle;
import com.zhilizhan.bhtpvz.common.damagesource.BHTPvZEntityDamageSource;
import com.zhilizhan.bhtpvz.common.entity.BHTPvZEntityTypes;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class DragonFireEntity  extends AbstractBulletEntity {

    public DragonFireEntity(EntityType<?> type, Level worldIn) {
        super(type, worldIn);
    }

    public DragonFireEntity(Level worldIn, LivingEntity shooter) {
        super(BHTPvZEntityTypes.DRAGON_FIRE.get(), worldIn, shooter);
    }
    protected int getMaxLiveTick() {
        return 20;
    }

    public ItemStack getItem() {
        return null;
    }

    protected void onImpact(HitResult result) {
        if (result.getType() == HitResult.Type.ENTITY) {
            Entity target = ((EntityHitResult)result).getEntity();
            if (this.shouldHit(target)) {
                target.invulnerableTime = 0;
                this.dealSonicDamage(target);
                if (this.hitEntities == null) {
                    this.hitEntities = new IntOpenHashSet();
                }

                this.addHitEntity(target);
            }
        }

        this.level.broadcastEntityEvent(this, (byte)3);
        if (!this.checkLive(result)) {
            this.remove();
        }

    }

    protected boolean checkLive(HitResult result) {
        if (result.getType() == HitResult.Type.BLOCK) {
            Block block = this.level.getBlockState(((BlockHitResult)result).getBlockPos()).getBlock();
            return block instanceof BushBlock;
        } else {
            return true;
        }
    }
    public void tick() {
        super.tick();
        if (this.level.isClientSide) {
            int cnt = Math.max(2, Math.min(7, this.getMaxLiveTick() / this.tickCount));

            for(int i = 0; i < cnt; ++i) {
                WorldUtil.spawnRandomSpeedParticle(this.level, BHTPvZParticle.SONIC_BOOM.get(), this.position(), 0.05F);
            }
        }

    }
    private void dealSonicDamage(Entity target) {
        if (!this.level.isClientSide ) {
            target.hurt(BHTPvZEntityDamageSource.dragonFire(this, this.getThrower()), this.attackDamage);
            target.setSecondsOnFire(3);
        }
    }

    public EntityDimensions getDimensions(Pose poseIn) {
        return EntityDimensions.scalable(0.15F, 0.15F);
    }

    protected float getGravityVelocity() {
        return 0.0001F;
    }
}
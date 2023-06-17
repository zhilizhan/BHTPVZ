package com.zhilizhan.bhtpvz.common.entity.bullet.itembullet;

import com.hungteen.pvz.common.entity.bullet.PultBulletEntity;
import com.hungteen.pvz.common.item.ItemRegister;
import com.hungteen.pvz.common.misc.PVZEntityDamageSource;
import com.hungteen.pvz.common.misc.sound.SoundRegister;
import com.hungteen.pvz.utils.EntityUtil;
import com.zhilizhan.bhtpvz.common.damagesource.BHTPvZEntityDamageSource;
import com.zhilizhan.bhtpvz.common.entity.BHTPvZEntityTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class PopCornEntity extends PultBulletEntity implements ItemSupplier {
    public PopCornEntity(EntityType<?> type, Level level) {
        super(type, level);
    }

    public PopCornEntity(Level level, LivingEntity shooter) {
        super(BHTPvZEntityTypes.POP_CORN.get(), level, shooter);
    }
    private Entity attackEntity = null;
    @Override
    protected void dealDamage(Entity target) {
        PVZEntityDamageSource source = BHTPvZEntityDamageSource.popCorn(this, this.getThrower());
        this.attackEntity = target;
        this.dealSplashDamage();
        target.hurt(source, this.attackDamage);
    }

    public void dealSplashDamage() {
        float range = 2.5F;
        EntityUtil.getTargetableEntities(this.getOwnerOrSelf(), EntityUtil.getEntityAABB(this, range, range)).forEach((entity) -> {
            if (!entity.is(this.attackEntity) && this.shouldHit(entity)) {
                PVZEntityDamageSource source = BHTPvZEntityDamageSource.popCorn(this, this.getThrower());
                entity.hurt(source, this.getAttackDamage() / 2.0F);

            }
            for(int i = 0; i < 10; ++i) {
                EntityUtil.spawnParticle(this,9);
            }

            EntityUtil.playSound(this, (SoundEvent) SoundRegister.SWING.get());
        });
    }
    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.scalable(0.6f, 0.6f);
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemRegister.POP_CORN.get());
    }
}

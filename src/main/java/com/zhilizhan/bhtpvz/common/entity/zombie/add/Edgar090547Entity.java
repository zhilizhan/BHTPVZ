package com.zhilizhan.bhtpvz.common.entity.zombie.add;

import com.hungteen.pvz.common.entity.plant.spear.SpikeRockEntity;
import com.hungteen.pvz.common.entity.zombie.roof.GargantuarEntity;
import com.hungteen.pvz.common.impl.zombie.ZombieType;
import com.zhilizhan.bhtpvz.common.impl.zombie.add.AddZombies;
import net.minecraft.entity.*;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Edgar090547Entity extends GargantuarEntity {


    public Edgar090547Entity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
        this.setIsWholeBody();
    }


    @Override
    public ZombieType getZombieType() {
        return AddZombies.EDGAR_090547;
    }


    @Override
    public float getLife() {
        return 300;
    }

    @Override
    public boolean canPAZTarget(Entity target) {
        if (target instanceof SpikeRockEntity) {
            return true;
        }
        return super.canPAZTarget(target);
    }


    @Override
    public EntitySize getDimensions(Pose poseIn) {
        if (this.isMiniZombie()) {
            return EntitySize.scalable(0.3F, 1F);
        }
        return EntitySize.scalable(0.4f, 2f);
    }

//explosion


     @Override
    protected void dropAllDeathLoot(DamageSource damageSourceIn) {

				Explosion.Mode mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
            this.level.explode(this, getX(), getY(), getZ(), 4.5f, Explosion.Mode.NONE);


    super.dropAllDeathLoot(damageSourceIn);
}


}
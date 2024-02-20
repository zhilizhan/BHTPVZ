package com.zhilizhan.bhtpvz.common.entity.zombie.bhtpvz;

import com.hungteen.pvz.common.entity.plant.base.PlantShooterEntity;
import com.hungteen.pvz.common.entity.zombie.PVZZombieEntity;
import com.hungteen.pvz.common.impl.zombie.ZombieType;
import com.hungteen.pvz.utils.ZombieUtil;
import com.zhilizhan.bhtpvz.common.impl.zombie.BHTPvZZombies;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;

public class FlowerPotZombieEntity extends PVZZombieEntity {
    public FlowerPotZombieEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean canLostHand() {
        return super.canLostHand();
    }


    @Override
    public float getWalkSpeed() {
        return ZombieUtil.WALK_LITTLE_SLOW;
    }

    @Override
    public boolean canBeTargetBy(LivingEntity living) {
        if(living instanceof PlantShooterEntity){
            return false;
        }
        return super.canBeTargetBy(living);
    }

    @Override
    public float getLife() {
        return 34;
    }

    @Override
    public ZombieType getZombieType() {
        return BHTPvZZombies.FLOWER_POT_ZOMBIE;
    }
}

package com.zhilizhan.bhtpvz.common.mixin.optional;

import com.hungteen.pvz.common.entity.plant.base.PlantShooterEntity;
import com.hungteen.pvz.common.entity.plant.toxic.ScaredyShroomEntity;
import com.zhilizhan.bhtpvz.config.BHTPvZConfig;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = ScaredyShroomEntity.class,remap = false)
public abstract class ScaredyShroomEntityMixin extends PlantShooterEntity {

	@Shadow public abstract boolean isScared();

	public ScaredyShroomEntityMixin(EntityType<? extends PathfinderMob> type, Level worldIn) {
		super(type, worldIn);
	}


	@Override
	public boolean canBeTargetBy(LivingEntity living) {
		return (!this.isScared() || !BHTPvZConfig.COMMON_CONFIG.EntitySettings.PlantSetting.ScaredyShroomSurrender.get()) && !this.hasMetal();
	}

}

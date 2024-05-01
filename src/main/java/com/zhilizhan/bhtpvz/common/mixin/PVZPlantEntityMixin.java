package com.zhilizhan.bhtpvz.common.mixin;

import com.hungteen.pvz.common.entity.AbstractPAZEntity;
import com.hungteen.pvz.common.entity.plant.PVZPlantEntity;
import com.hungteen.pvz.utils.AlgorithmUtil;
import com.zhilizhan.bhtpvz.common.block.BHTPvZBlocks;
import com.zhilizhan.bhtpvz.config.BHTPvZConfig;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PVZPlantEntity.class,remap = false)
public abstract class PVZPlantEntityMixin extends AbstractPAZEntity {


    public PVZPlantEntityMixin(EntityType<?> arg, Level arg2) {
        super((EntityType<? extends PathfinderMob>) arg, arg2);
    }


    @Redirect(method = "shouldWilt",at = @At(value = "INVOKE", target = "Lcom/hungteen/pvz/common/entity/plant/PVZPlantEntity;isInWater()Z"))
    public boolean shouldWilt(PVZPlantEntity instance) {
        return !instance.isInWater() && !this.level.getBlockState(instance.blockPosition().below()).is(BHTPvZBlocks.WATER_POT.get());
    }
    //STEEL PUMPKIN FLAG = 5
    @Inject(method = "canBeTargetBy", at = @At("HEAD"), cancellable = true)
    public void canBeTargetBy(LivingEntity living, CallbackInfoReturnable<Boolean> cir) {
        boolean flag = !AlgorithmUtil.BitOperator.hasBitOne(this.getPAZState(), 5);
        cir.setReturnValue(flag);
        cir.cancel();
    }

    @Inject(method = "shouldPlantRegularSleep", at = @At("HEAD"), cancellable = true)
    protected void shouldPlantRegularSleep(CallbackInfoReturnable<Boolean> cir) {
        boolean flag1 = this.level.getBlockState(blockPosition().below())== Blocks.MYCELIUM.defaultBlockState()&&BHTPvZConfig.COMMON_CONFIG.EntitySettings.PlantSetting.MyceliumSleep.get();
        if(flag1)cir.setReturnValue(false);
    }
    @Inject(method = "removeOuterPlant", at = @At("TAIL"))
    public void removeOuterPlant(CallbackInfo ci) {
        this.setPAZState(AlgorithmUtil.BitOperator.setBit(this.getPAZState(), 5, false));
    }

}


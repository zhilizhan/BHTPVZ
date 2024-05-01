package com.zhilizhan.bhtpvz.common.mixin;

import com.hungteen.pvz.common.entity.plant.PVZPlantEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LivingEntityRenderer.class,remap = false)
public abstract class LivingEntityRenderMixin<T extends LivingEntity, M extends EntityModel<T>> extends EntityRenderer<T> implements RenderLayerParent<T, M> {

    protected LivingEntityRenderMixin(EntityRenderDispatcher arg) {
        super(arg);
    }

    @Inject(method = "getFlipDegrees", at = @At("HEAD"), cancellable = true)
    protected void getFlipDegrees(T livingEntity, CallbackInfoReturnable<Float> cir) {
        boolean flag = livingEntity instanceof PVZPlantEntity && ((PVZPlantEntity) livingEntity).isNoAi();
        float f = flag ? 0: 90.0F;
        cir.setReturnValue(f);
        cir.cancel();
    }

}

package com.zhilizhan.bhtpvz.client.render.entity.bullet;

import com.mojang.blaze3d.vertex.PoseStack;
import com.zhilizhan.bhtpvz.client.model.entity.bullet.BeeEntityModel;
import com.zhilizhan.bhtpvz.common.entity.bullet.BeeEntity;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BeeEntityRender extends MobRenderer<BeeEntity, BeeEntityModel<BeeEntity>> {

    public BeeEntityRender(EntityRenderDispatcher renderManager) {
        super(renderManager, new BeeEntityModel<>(),0.2f);
    }

    protected float getScaleByEntity(BeeEntity entity) {
        return  0.25F;
    }
    protected void scale(BeeEntity livingEntity, PoseStack matrixStack, float partialTickTime) {
        matrixStack.scale(0.45f, 0.45f,0.45f);
    }
    public ResourceLocation getTextureLocation(BeeEntity entity) {
        return new ResourceLocation("textures/entity/bee/bee_angry.png");
    }
}

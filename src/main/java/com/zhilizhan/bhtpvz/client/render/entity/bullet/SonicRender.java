package com.zhilizhan.bhtpvz.client.render.entity.bullet;

import com.zhilizhan.bhtpvz.common.entity.bullet.SonicEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class SonicRender  extends EntityRenderer<SonicEntity> {
    public SonicRender(EntityRenderDispatcher renderManager) {
        super(renderManager);
    }

    @Override
    public ResourceLocation getTextureLocation(SonicEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(@NotNull SonicEntity livingEntityIn, @NotNull Frustum camera, double camX, double camY, double camZ) {
        if (!this.entityRenderDispatcher.shouldRenderHitBoxes())
            return false;
        return super.shouldRender(livingEntityIn, camera, camX, camY, camZ);
    }

    public BlockState getBlockByEntity(SonicEntity entity) {
        return Blocks.NOTE_BLOCK.defaultBlockState();
    }
}

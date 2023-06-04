package com.zhilizhan.bhtpvz.client.render.entity.plant.fire;

import com.hungteen.pvz.client.render.entity.plant.PVZPlantRender;
import com.zhilizhan.bhtpvz.client.model.entity.plant.fire.BlazeWartModel;
import com.zhilizhan.bhtpvz.client.render.layer.NetherWartLayer;
import com.zhilizhan.bhtpvz.common.entity.plant.fire.BlazeWartEntity;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BlazeWartRender extends PVZPlantRender<BlazeWartEntity>{
    public BlazeWartRender(EntityRenderDispatcher rendererManager) {
        super(rendererManager, new BlazeWartModel(), 0.4f);
    }
    protected void addPlantLayers() {
        super.addPlantLayers();
        this.addLayer(new NetherWartLayer(this));
    }

}

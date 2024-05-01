package com.zhilizhan.bhtpvz.client.render.entity.zombie.bhtpvz;

import com.hungteen.pvz.client.render.entity.zombie.PVZZombieRender;
import com.zhilizhan.bhtpvz.client.model.entity.zombie.bhtpvz.MCZombieModel;
import com.zhilizhan.bhtpvz.common.entity.zombie.bhtpvz.MCZombieEntity;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MCZombieRender extends PVZZombieRender<MCZombieEntity> {
	public MCZombieRender(EntityRenderDispatcher rendererManager) {
		super(rendererManager, new MCZombieModel(), 0.5f);
	}
}

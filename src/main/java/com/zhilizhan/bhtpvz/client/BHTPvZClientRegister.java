package com.zhilizhan.bhtpvz.client;

import com.hungteen.pvz.client.model.baked.PVZBakedModel;
import com.mojang.datafixers.util.Pair;
import com.zhilizhan.bhtpvz.client.particle.BHTPvZParticle;
import com.zhilizhan.bhtpvz.client.particle.GoldNuggetParticle;
import com.zhilizhan.bhtpvz.client.particle.OriginalFumeParticle;
import com.zhilizhan.bhtpvz.client.particle.SonicBoomParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BHTPvZClientRegister {
    public BHTPvZClientRegister() {
    }
    @SubscribeEvent
    public static void registerFactories(ParticleFactoryRegisterEvent event) {
        ParticleEngine manager = Minecraft.getInstance().particleEngine;
        manager.register(BHTPvZParticle.GOLD_NUGGET.get(), GoldNuggetParticle.Factory::new);
        manager.register(BHTPvZParticle.ORIGINAL_FUME.get(), OriginalFumeParticle.Factory::new);
        manager.register(BHTPvZParticle.SONIC_BOOM.get(), SonicBoomParticle.Factory::new);
    }


    private static Pair<BakedModel, ModelResourceLocation> getBakedModel(ModelBakeEvent ev, Item item) {
        Map<ResourceLocation, BakedModel> modelRegistry = ev.getModelRegistry();
        ModelResourceLocation location = new ModelResourceLocation(item.getRegistryName(), "inventory");
        BakedModel model = modelRegistry.get(location);
        if (model == null) {
            throw new RuntimeException("Did not find Obsidian Hidden in registry");
        } else if (model instanceof PVZBakedModel) {
            throw new RuntimeException("Tried to replaceObsidian Hidden twice");
        } else {
            return Pair.of(model, location);
        }
    }
}

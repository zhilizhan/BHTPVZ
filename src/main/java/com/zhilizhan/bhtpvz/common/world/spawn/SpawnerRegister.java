package com.zhilizhan.bhtpvz.common.world.spawn;

import com.zhilizhan.bhtpvz.BHTPvZ;
import com.zhilizhan.bhtpvz.common.entity.BHTPvZEntityTypes;
import com.zhilizhan.bhtpvz.common.world.biome.BHTPvZBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BHTPvZ.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SpawnerRegister {


    @SubscribeEvent(priority =  EventPriority.HIGH)
    public static void addSpawn(BiomeLoadingEvent event) {
        ResourceKey<Biome> biomeKey = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        if(biomeKey== BHTPvZBiomes.NIGHT_KEY) {
            event.getSpawns().addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(BHTPvZEntityTypes.ORIGIN_MOOB.get(), 10, 1, 1));
        }
    }


}

package com.github.zhilizhan.bhtpvz.common.world.biome;

import com.github.zhilizhan.bhtpvz.BHTPvZ;

import com.github.zhilizhan.bhtpvz.common.world.BHTPvZFeatures;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BHTPvZBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, BHTPvZ.MOD_ID);

    public static final RegistryObject<Biome> NIGHT = BIOMES.register("night", BHTPvZBiomes::nightBiome);
    public static final ResourceKey<Biome> NIGHT_KEY = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(BHTPvZ.MOD_ID, "night"));

    private static Biome biome(Biome.BiomeCategory category, Biome.Precipitation rainType, float depth, float scale, float temperature, float downFall, BiomeSpecialEffects effect, MobSpawnSettings spawnSettings, BiomeGenerationSettings generateSettings) {
        return new Biome.BiomeBuilder().biomeCategory(category).precipitation(rainType).depth(depth).scale(scale).temperature(temperature).downfall(downFall).specialEffects(effect).mobSpawnSettings(spawnSettings).generationSettings(generateSettings).build();
    }

    public static void addBiomeTypes() {
        BiomeDictionary.addTypes(NIGHT_KEY, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    }

    public static void addBiomesToGeneration() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(NIGHT_KEY, 10));
    }

    public static Biome nightBiome() {
        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder().fogColor(0x4f4E55).waterColor(0x8A8997).waterFogColor(0x8A8997).skyColor(0x4f4E55).foliageColorOverride(0x2BBB0f).grassColorOverride(0x55C93f).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        spawnSettings.setPlayerCanSpawn();
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.MOOSHROOM, 8, 4, 8));
        BiomeGenerationSettings.Builder biomeGenerationSettings = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.MYCELIUM);
        biomeGenerationSettings.addStructureStart(StructureFeatures.STRONGHOLD); //生成末地传送门
        BiomeDefaultFeatures.addMushroomFieldVegetation(biomeGenerationSettings); //生成大蘑菇
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings); //生成蘑菇
        BiomeDefaultFeatures.addDefaultCarvers(biomeGenerationSettings); //生成矿洞和峡谷
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings); //生成矿石
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BHTPvZFeatures.PATCH_TOXIC_SHROOM); //生成孢子
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BHTPvZFeatures.PATCH_QUESTION_MARK_POT); //生成问号罐
        return biome(Biome.BiomeCategory.PLAINS, Biome.Precipitation.RAIN, 0.125f, 0.25f, 0.8f, 0.4f, effects.build(), spawnSettings.build(), biomeGenerationSettings.build());
    }
}
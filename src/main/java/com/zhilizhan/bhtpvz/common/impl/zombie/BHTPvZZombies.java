package com.zhilizhan.bhtpvz.common.impl.zombie;

import com.zhilizhan.bhtpvz.BHTPvZ;
import com.zhilizhan.bhtpvz.client.model.entity.zombie.bhtpvz.AirborneZombieModel;
import com.zhilizhan.bhtpvz.client.model.entity.zombie.bhtpvz.FlowerPotZombieModel;
import com.zhilizhan.bhtpvz.client.model.entity.zombie.bhtpvz.MCZombieModel;
import com.zhilizhan.bhtpvz.client.model.entity.zombie.bhtpvz.TargetArrowZombieModel;
import com.zhilizhan.bhtpvz.common.entity.BHTPvZEntityTypes;

import com.hungteen.pvz.api.types.IZombieType;
import com.hungteen.pvz.client.model.entity.zombie.roof.EdgarRobotModel;
import com.hungteen.pvz.common.impl.RankTypes;
import com.hungteen.pvz.common.impl.zombie.ZombieType;

import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BHTPvZZombies extends ZombieType {
	private static final List<IZombieType> LIST = new ArrayList<>();

	// Zombotany
	public static final ZombieType EDGAR_090547 = new BHTPvZZombies("edgar_090547", new ZombieFeatures().rank(RankTypes.PURPLE).xp(50).entityType(BHTPvZEntityTypes.EDGAR_090547::get).zombieModel(() -> EdgarRobotModel::new).scale(0.5f).eatCommonSkill(Collections.emptyList()));
	public static final ZombieType FLOWER_POT_ZOMBIE = new BHTPvZZombies("flower_pot_zombie", new ZombieFeatures().rank(RankTypes.GREEN).xp(10).entityType(BHTPvZEntityTypes.FLOWER_POT_ZOMBIE::get).zombieModel(() -> FlowerPotZombieModel::new).scale(0.5f).eatCommonSkill(Collections.emptyList()));
	public static final ZombieType AIRBORNE_ZOMBIE = new BHTPvZZombies("airborne_zombie", new ZombieFeatures().rank(RankTypes.GREEN).xp(10).entityType(BHTPvZEntityTypes.AIRBORNE_ZOMBIE::get).zombieModel(() -> AirborneZombieModel::new).scale(0.5f).eatCommonSkill(Collections.emptyList()));
	public static final ZombieType MC_ZOMBIE = new BHTPvZZombies("mc_zombie", new ZombieFeatures().rank(RankTypes.WHITE).xp(5).entityType(BHTPvZEntityTypes.MC_ZOMBIE::get).zombieModel(() -> MCZombieModel::new).scale(0.5f).eatCommonSkill(Collections.emptyList()));
	public static final ZombieType STEEL_PUMPKIN_ZOMBIE = new BHTPvZZombies("steel_pumpkin_zombie", new ZombieFeatures().rank(RankTypes.BLUE).xp(25).entityType(BHTPvZEntityTypes.STEEL_PUMPKIN_ZOMBIE::get).zombieModel(() -> MCZombieModel::new).scale(0.5f).eatCommonSkill(Collections.emptyList()));
	public static final ZombieType TARGET_ARROW_ZOMBIE = new BHTPvZZombies("target_arrow_zombie", new ZombieFeatures().rank(RankTypes.GREEN).xp(8).entityType(BHTPvZEntityTypes.TARGET_ARROW_ZOMBIE::get).zombieModel(() -> TargetArrowZombieModel::new).scale(0.5f).eatCommonSkill(Collections.emptyList()));

	public static void register() {
		registerZombies(LIST);
	}

	private BHTPvZZombies(String name, ZombieFeatures features) {
		super(name, features);
		LIST.add(this);
	}

	@Override
	public int getSortPriority() {
		return 80;
	}

	@Override
	public String getCategoryName() {
		return "bhtpvz";
	}

	@Override
	public String getModID() {
		return BHTPvZ.MOD_ID;
	}

	@Override
	protected ResourceLocation getEntityResource() {
		return new ResourceLocation(this.getModID(), "textures/entity/zombie/" + this.getCategoryName() + "/" + this + ".png");
	}
}
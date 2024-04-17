package com.zhilizhan.bhtpvz.common.event;

import com.hungteen.pvz.PVZMod;
import com.hungteen.pvz.common.enchantment.EnchantmentRegister;
import com.hungteen.pvz.common.entity.plant.PVZPlantEntity;
import com.hungteen.pvz.common.potion.EffectRegister;
import com.hungteen.pvz.utils.EntityUtil;
import com.hungteen.pvz.utils.PlayerUtil;
import com.hungteen.pvz.utils.enums.Resources;
import com.zhilizhan.bhtpvz.common.item.BHTPvZItems;
import com.zhilizhan.bhtpvz.common.util.Utils;
import net.minecraft.ChatFormatting;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PVZMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LivingEvents {

	@SubscribeEvent
	public static void PlayerRightClickItem(PlayerInteractEvent.EntityInteractSpecific event) {
		Entity entity = event.getTarget();
		Player player = event.getPlayer();
		Item item = event.getPlayer().getMainHandItem().getItem();
		if(! event.getWorld().isClientSide&&event.getHand() == InteractionHand.MAIN_HAND){
			if (entity instanceof PVZPlantEntity && EntityUtil.isEntityValid(entity) && (item.equals(BHTPvZItems.DAMSON_CRYSTAL_SWORD.get()) || EnchantmentHelper.getItemEnchantmentLevel((Enchantment) EnchantmentRegister.ENERGY_TRANSFER.get(), item.getDefaultInstance()) > 0) && ((PVZPlantEntity)entity).canStartSuperMode() && (!PlayerUtil.isPlayerSurvival(player) || PlayerUtil.getResource(player, Resources.ENERGY_NUM) > 0)) {
			if (PlayerUtil.isPlayerSurvival(player)) {
				PlayerUtil.addResource(player, Resources.ENERGY_NUM, -1);
			}
			((PVZPlantEntity)entity).startSuperMode(true);
			int treeLevel = PlayerUtil.getResource(player, Resources.TREE_LVL);
			player.addEffect(new MobEffectInstance((MobEffect) EffectRegister.ENERGETIC_EFFECT.get(), 100 + (treeLevel + 1) / 2, 0));
		}

	}}
	@SubscribeEvent
	public void playerClick(PlayerInteractEvent.RightClickBlock e) {
		Player player = e.getPlayer();
		Level world = player.getCommandSenderWorld();
		if (!world.isClientSide && e.getHand().equals(InteractionHand.MAIN_HAND)) {
            Block block = world.getBlockState(e.getPos()).getBlock();
            if (block instanceof BedBlock) {
                Integer sleeptime = 12000;//可以入眠的tick时间;
                Integer currenttime = (int)world.getDayTime();
                Integer days = (int)Math.floor((double)currenttime / 24000.0);
                Integer daytime = currenttime - days * 24000;
                if (sleeptime > 12540 && daytime > 12540 && daytime < sleeptime) {//判断是否可以入眠,true为不能入眠

                    e.setCanceled(true);
					if(e.getPlayer() instanceof ServerPlayer) {
						((ServerPlayer)player).setRespawnPosition(world.dimension(), e.getPos(), 0.0F, false, true);
						Utils.sendMessage(player, "block.bhtpvz.sleep_failure", ChatFormatting.DARK_GREEN);//设置重生点的消息
					}
					Utils.sendMessage(player, "block.bhtpvz.sleep_failure2", ChatFormatting.DARK_GREEN);

				} else if (daytime <= 12540) {
                    if (daytime >= sleeptime) {
                        Utils.setWorldTime((ServerLevel)world, 12540);
                        if (true) {//ture为启用睡眠前消息,看需求删掉
							Utils.sendMessage(player, "block.bhtpvz.sleep_failure3", ChatFormatting.DARK_GREEN);
                        }

                    }
                }
            }
        }
	}
}

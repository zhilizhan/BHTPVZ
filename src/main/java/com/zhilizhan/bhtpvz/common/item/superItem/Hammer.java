package com.zhilizhan.bhtpvz.common.item.superItem;

import com.hungteen.pvz.common.entity.zombie.PVZZombieEntity;
import com.zhilizhan.bhtpvz.common.item.ItemRegistry;
import com.zhilizhan.bhtpvz.common.item.tools.BhtpvzTools;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;

public class Hammer extends SwordItem {
    public Hammer(BhtpvzTools hammre, int i, float v, Properties properties) {
        super(hammre, i, v, properties);
    }

    public ActionResultType interactLivingEntity(ItemStack itemStack, PlayerEntity playerEntity, LivingEntity livingEntity, Hand hand) {
        //检查是否有CD
        if (playerEntity.getCooldowns().isOnCooldown(ItemRegistry.HAMMER.get())){
            //如果有CD则结束方法
            return ActionResultType.FAIL;
        }else if (livingEntity instanceof PVZZombieEntity) {
            //如果没有CD就执行一下语句
            //对PVZ僵尸照成20点伤害
            livingEntity.hurt(DamageSource.MAGIC, 20.0F);
            //减少锤子5点耐久
            itemStack.hurtAndBreak(5, livingEntity, (p_0) -> {
                p_0.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });
            //如果是生存模式添加30tick的CD
            if (!playerEntity.isCreative()) {
                playerEntity.getCooldowns().addCooldown(ItemRegistry.HAMMER.get(), 30);
            }
        }
        return ActionResultType.SUCCESS;
    }
}
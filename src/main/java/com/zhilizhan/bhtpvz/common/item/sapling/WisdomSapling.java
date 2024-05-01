package com.zhilizhan.bhtpvz.common.item.sapling;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class WisdomSapling extends AbstractXpSapling {
    public WisdomSapling(Properties properties) {
        super(properties);
    }
    public boolean isFoil(ItemStack stack) {
        return true;
    }
    @Override
    protected int amount(){
        return 500;
    }
    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        tooltipComponents.add(new TranslatableComponent("tooltip.bhtpvz.wisdom_sapling.use").withStyle(ChatFormatting.GREEN));
    }
}

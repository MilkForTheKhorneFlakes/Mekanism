package mekanism.common.item.block.transmitter;

import java.util.List;
import mekanism.api.text.EnumColor;
import mekanism.client.key.MekKeyHandler;
import mekanism.client.key.MekanismKeyHandler;
import mekanism.common.MekanismLang;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.block.transmitter.BlockPressurizedTube;
import mekanism.common.item.block.ItemBlockMekanism;
import mekanism.common.tier.TubeTier;
import mekanism.common.util.text.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ItemBlockPressurizedTube extends ItemBlockMekanism<BlockPressurizedTube> {

    public ItemBlockPressurizedTube(BlockPressurizedTube block) {
        super(block, new Item.Properties());
    }

    @NotNull
    @Override
    public TubeTier getTier() {
        return Attribute.getTier(getBlock(), TubeTier.class);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        if (MekKeyHandler.isKeyPressed(MekanismKeyHandler.detailsKey)) {
            tooltip.add(MekanismLang.CAPABLE_OF_TRANSFERRING.translateColored(EnumColor.DARK_GRAY));
            tooltip.add(MekanismLang.GASES.translateColored(EnumColor.PURPLE, MekanismLang.MEKANISM));
            tooltip.add(MekanismLang.INFUSE_TYPES.translateColored(EnumColor.PURPLE, MekanismLang.MEKANISM));
            tooltip.add(MekanismLang.PIGMENTS.translateColored(EnumColor.PURPLE, MekanismLang.MEKANISM));
            tooltip.add(MekanismLang.SLURRIES.translateColored(EnumColor.PURPLE, MekanismLang.MEKANISM));
        } else {
            TubeTier tier = getTier();
            tooltip.add(MekanismLang.CAPACITY_MB_PER_TICK.translateColored(EnumColor.INDIGO, EnumColor.GRAY, TextUtils.format(tier.getTubeCapacity())));
            tooltip.add(MekanismLang.PUMP_RATE_MB.translateColored(EnumColor.INDIGO, EnumColor.GRAY, TextUtils.format(tier.getTubePullAmount())));
            tooltip.add(MekanismLang.HOLD_FOR_DETAILS.translateColored(EnumColor.GRAY, EnumColor.INDIGO, MekanismKeyHandler.detailsKey.getTranslatedKeyMessage()));
        }
    }
}
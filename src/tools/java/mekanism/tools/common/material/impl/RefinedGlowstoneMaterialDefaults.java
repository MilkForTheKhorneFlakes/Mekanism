package mekanism.tools.common.material.impl;

import mekanism.common.tags.MekanismTags;
import mekanism.tools.common.ToolsTags;
import mekanism.tools.common.material.BaseMekanismMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RefinedGlowstoneMaterialDefaults extends BaseMekanismMaterial {

    @Override
    public int getShieldDurability() {
        return 381;
    }

    @Override
    public float getAxeDamage() {
        return 6;
    }

    @Override
    public float getAxeAtkSpeed() {
        return -2.9F;
    }

    @Override
    public int getUses() {
        return 384;
    }

    @Override
    public float getSpeed() {
        return 15;
    }

    @Override
    public float getAttackDamageBonus() {
        return 2;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getCommonEnchantability() {
        return 20;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public int getDurabilityForType(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 221;
            case LEGGINGS -> 255;
            case CHESTPLATE -> 272;
            case HELMET -> 187;
        };
    }

    @Override
    public int getDefenseForType(@NotNull ArmorItem.Type armorType) {
        return switch (armorType) {
            case BOOTS -> 3;
            case LEGGINGS -> 6;
            case CHESTPLATE -> 8;
            case HELMET -> 3;
        };
    }

    @NotNull
    @Override
    public String getConfigCommentName() {
        return "Refined Glowstone";
    }

    @NotNull
    @Override
    public String getRegistryPrefix() {
        return "refined_glowstone";
    }

    @Nullable
    @Override
    public TagKey<Block> getTag() {
        return ToolsTags.Blocks.NEEDS_REFINED_GLOWSTONE_TOOL;
    }

    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_IRON;
    }

    @NotNull
    @Override
    public Ingredient getCommonRepairMaterial() {
        return Ingredient.of(MekanismTags.Items.INGOTS_REFINED_GLOWSTONE);
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
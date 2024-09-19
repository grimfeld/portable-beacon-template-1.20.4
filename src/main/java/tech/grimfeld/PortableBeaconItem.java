package tech.grimfeld;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PortableBeaconItem extends Item {

    private final StatusEffect effect;

    public PortableBeaconItem(Settings settings, StatusEffect effect) {
        super(settings);
        this.effect = effect;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity) {
            // Check if the entity already has the effect with sufficient duration
            StatusEffectInstance existingEffect = livingEntity.getStatusEffect(effect);
            if (existingEffect == null || existingEffect.getDuration() <= 10) {
                livingEntity.addStatusEffect(new StatusEffectInstance(effect, 220, 1, true, false, true));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}

package tech.grimfeld;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PortableBeaconsMod implements ModInitializer {

	public static final String MOD_ID = "portable-beacon";

	public static Item SPEED_BEACON;
	public static Item STRENGTH_BEACON;
	public static Item HASTE_BEACON;
	public static Item REGENERATION_BEACON;
	public static Item JUMP_BOOST_BEACON;
	public static Item RESISTANCE_BEACON;

	@Override
	public void onInitialize() {
		// Initialize and register items
		SPEED_BEACON = new PortableBeaconItem(new Item.Settings().maxCount(1), StatusEffects.SPEED);
		STRENGTH_BEACON = new PortableBeaconItem(new Item.Settings().maxCount(1), StatusEffects.STRENGTH);
		HASTE_BEACON = new PortableBeaconItem(new Item.Settings().maxCount(1), StatusEffects.HASTE);
		REGENERATION_BEACON = new PortableBeaconItem(new Item.Settings().maxCount(1), StatusEffects.REGENERATION);
		JUMP_BOOST_BEACON = new PortableBeaconItem(new Item.Settings().maxCount(1), StatusEffects.JUMP_BOOST);
		RESISTANCE_BEACON = new PortableBeaconItem(new Item.Settings().maxCount(1), StatusEffects.RESISTANCE);

		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "speed_beacon"), SPEED_BEACON);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "strength_beacon"), STRENGTH_BEACON);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "haste_beacon"), HASTE_BEACON);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "regeneration_beacon"), REGENERATION_BEACON);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "jump_boost_beacon"), JUMP_BOOST_BEACON);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "resistance_beacon"), RESISTANCE_BEACON);

		// Add items to the Tools item group
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.add(SPEED_BEACON);
			content.add(STRENGTH_BEACON);
			content.add(HASTE_BEACON);
			content.add(REGENERATION_BEACON);
			content.add(JUMP_BOOST_BEACON);
			content.add(RESISTANCE_BEACON);
		});
	}
}

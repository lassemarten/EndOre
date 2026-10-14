package lasse.endores;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;


import java.util.Map;

public class EndArmorMaterial {
    public static final int BASE_DURABILITY = 50; // Eisen: 15, Diamant: 33

    public static final TagKey<Item> REPAIRS_END_ARMOR = TagKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(Endore.MOD_ID, "repairs_end_armor"));

    public static final ResourceKey<EquipmentAsset> END_ARMOR_KEY = ResourceKey.create(
            EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(Endore.MOD_ID, "end"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 4,
                    ArmorType.CHESTPLATE, 10,
                    ArmorType.LEGGINGS, 8,
                    ArmorType.BOOTS, 4
            ),
            30,                              // Verzauberbarkeit
            SoundEvents.ARMOR_EQUIP_NETHERITE, // Anlegegeräusch
            4.5F,                            // Zähigkeit (Toughness)
            0.5F,                            // Rückstoßresistenz
            REPAIRS_END_ARMOR,
            END_ARMOR_KEY
    );
}

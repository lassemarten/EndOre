package lasse.endores;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class LootModifier {

    private static final ResourceKey<LootTable> ENDERMAN_LOOT = ResourceKey.create(
            Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/enderman"));

    public static void initialize() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            // END CITY LOOT
            if (source.isBuiltin() && BuiltInLootTables.END_CITY_TREASURE.equals(key)) {
                LootPool.Builder pool = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.02f)) // 2 %
                        .add(LootItem.lootTableItem(ModItems.END_TEMPLATE));
                tableBuilder.withPool(pool);
            }
            // ENDERMAN LOOT
            if (source.isBuiltin() && ENDERMAN_LOOT.equals(key)) {
                LootPool.Builder pool = LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.09f)) // 9 %
                        .add(LootItem.lootTableItem(ModItems.ENDER_SOUL));
                tableBuilder.withPool(pool);
            }
        });
    }
}
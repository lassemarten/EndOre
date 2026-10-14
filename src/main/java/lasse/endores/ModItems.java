package lasse.endores;


import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.util.function.Function;

public class ModItems {

    public static final Item RAW_END = register("raw_end", Item::new, new Item.Properties());

    // End
    public static final Item END = register("end", Item::new, new Item.Properties());

    // Werkzeugmaterial
    public static final TagKey<Item> REPAIRS_END_TOOL =
            TagKey.create(Registries.ITEM, Endore.id("repairs_end_tool"));

    public static final ToolMaterial END_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL, // Stufe: Eisen
            5000,    // Haltbarkeit
            10.0f,   // Abbautempo
            4.0f,   // zusätzlicher Angriffsschaden
            30,     // Verzauberbarkeit
            REPAIRS_END_TOOL
    );

    // Werkzeuge
    public static final Item END_SWORD = register("end_sword", Item::new,
            new Item.Properties().sword(END_TOOL_MATERIAL, 5.0f, -2.4f));

    public static final Item END_PICKAXE = register("end_pickaxe", Item::new,
            new Item.Properties().pickaxe(END_TOOL_MATERIAL, 1.0f, -2.8f));

    public static final Item END_AXE = register("end_axe",
            props -> new Item(props.axe(END_TOOL_MATERIAL, 6.0f, -3.1f)),
            new Item.Properties()
    );

    public static final Item END_SHOVEL = register("end_shovel",
            props -> new Item(props.shovel(END_TOOL_MATERIAL, 1.5f, -3.0f)),
            new Item.Properties());

    public static final Item END_HOE = register("end_hoe",
            props -> new Item(props.hoe(END_TOOL_MATERIAL, -2.0f, -1.0f)),
            new Item.Properties());

    private static Item register(String name,
                                 Function<Item.Properties, Item> factory,
                                 Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Endore.id(name));
        Item item = factory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register(output ->{
                    output.accept(RAW_END);
                    output.accept(END);
                });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(output -> {
                    output.accept(END_AXE);
                    output.accept(END_PICKAXE);
                    output.accept(END_SHOVEL);
                    output.accept(END_HOE);
                });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register(output -> {
                    output.accept(END_SWORD);
                    output.accept(END_AXE);
                });
    }
}

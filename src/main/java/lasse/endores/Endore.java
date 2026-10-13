package lasse.endores;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Endore implements ModInitializer {
	public static final String MOD_ID = "endore";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	// Test
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModBlocks.initialize();
		ModItems.initialize();
		BiomeModifications.addFeature(
				BiomeSelectors.foundInTheEnd(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				ResourceKey.create(Registries.PLACED_FEATURE, id("end_ore"))
		);
		LOGGER.info("Hello Fabric world!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}

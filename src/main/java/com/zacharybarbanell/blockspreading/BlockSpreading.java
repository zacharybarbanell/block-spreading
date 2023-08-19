package com.zacharybarbanell.blockspreading;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockSpreading implements ModInitializer {
	public static final String MOD_ID = "blockspreading";

	public static final TagKey<Block> SPREADS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "spreads"));
	public static final TagKey<Block> SUBSTRATES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "substrates"));

	@Override
	public void onInitialize() {
		
	}
}
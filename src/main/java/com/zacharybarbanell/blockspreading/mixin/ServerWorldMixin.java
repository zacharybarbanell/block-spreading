package com.zacharybarbanell.blockspreading.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.WorldChunk;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.zacharybarbanell.blockspreading.ExampleMod;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
	@Inject(method = "tickChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;hasRandomTicks()Z", ordinal = 0), locals = LocalCapture.CAPTURE_FAILHARD)
	private void onRandomTick(WorldChunk chunk, int randomTickSpeed, CallbackInfo ci, ChunkPos chunkPos, boolean bl, int i,
			int j, Profiler profiler, ChunkSection chunkSections[], int m, ChunkSection chunkSection, int k, int n,
			int l, BlockPos blockPos3, BlockState blockState4) {
		if (blockState4.isIn(ExampleMod.SPREADS)) {
			World world = chunk.getWorld();
			Random random = world.getRandom();
			for (int x = 0; x < 3; x++) {
				BlockPos target = blockPos3.add(random.nextInt(3) - 1, random.nextInt(3) - 1, random.nextInt(3) - 1);
				if (world.getBlockState(target).isIn(ExampleMod.SUBSTRATES)) {
					world.setBlockState(target, blockState4);
				}
			}
		}
	}
}
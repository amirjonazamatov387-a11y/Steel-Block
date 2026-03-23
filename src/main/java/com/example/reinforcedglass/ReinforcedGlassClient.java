package com.example.reinforcedglass;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class ReinforcedGlassClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for (var block : ModBlocks.BLOCKS.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.translucent());
        }
    }
}

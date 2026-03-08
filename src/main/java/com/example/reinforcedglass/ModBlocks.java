package com.example.reinforcedglass;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {
    public static final Map<String, Block> BLOCKS = new LinkedHashMap<>();
    private static final List<Item> ITEMS = new ArrayList<>();

    public static final Map<String, DyeColor> COLOR_MAP = new LinkedHashMap<>();
    static {
        COLOR_MAP.put("white", DyeColor.WHITE);
        COLOR_MAP.put("orange", DyeColor.ORANGE);
        COLOR_MAP.put("magenta", DyeColor.MAGENTA);
        COLOR_MAP.put("light_blue", DyeColor.LIGHT_BLUE);
        COLOR_MAP.put("yellow", DyeColor.YELLOW);
        COLOR_MAP.put("lime", DyeColor.LIME);
        COLOR_MAP.put("pink", DyeColor.PINK);
        COLOR_MAP.put("gray", DyeColor.GRAY);
        COLOR_MAP.put("light_gray", DyeColor.LIGHT_GRAY);
        COLOR_MAP.put("cyan", DyeColor.CYAN);
        COLOR_MAP.put("purple", DyeColor.PURPLE);
        COLOR_MAP.put("blue", DyeColor.BLUE);
        COLOR_MAP.put("brown", DyeColor.BROWN);
        COLOR_MAP.put("green", DyeColor.GREEN);
        COLOR_MAP.put("red", DyeColor.RED);
        COLOR_MAP.put("black", DyeColor.BLACK);
    }

    public static void registerBlocks() {
        COLOR_MAP.forEach((name, dye) -> {
            registerReinforcedGlass(name, dye);
            registerReinforcedGlassPane(name, dye);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(content -> {
            for (Item item : ITEMS) {
                content.accept(item);
            }
        });
    }

    private static void registerReinforcedGlass(String color, DyeColor dye) {
        String name = color + "_reinforced_glass";
        Block block = new StainedGlassBlock(dye, BlockBehaviour.Properties.of()
                .strength(45.0f, 20.0f)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn((state, world, pos, type) -> false)
                .isRedstoneConductor((state, world, pos) -> false)
                .isSuffocating((state, world, pos) -> false)
                .isViewBlocking((state, world, pos) -> false));

        registerBlockAndItem(name, block);
    }

    private static void registerReinforcedGlassPane(String color, DyeColor dye) {
        String name = color + "_reinforced_glass_pane";
        Block block = new StainedGlassPaneBlock(dye, BlockBehaviour.Properties.of()
                .strength(45.0f, 20.0f)
                .sound(SoundType.GLASS)
                .noOcclusion());

        registerBlockAndItem(name, block);
    }

    private static void registerBlockAndItem(String name, Block block) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ReinforcedGlass.MOD_ID, name);
        Registry.register(BuiltInRegistries.BLOCK, id, block);
        Item item = Registry.register(BuiltInRegistries.ITEM, id, new BlockItem(block, new Item.Properties()));
        BLOCKS.put(name, block);
        ITEMS.add(item);
    }
}

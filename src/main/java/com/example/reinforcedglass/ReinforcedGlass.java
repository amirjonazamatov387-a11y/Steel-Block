package com.example.reinforcedglass;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReinforcedGlass implements ModInitializer {
    public static final String MOD_ID = "reinforcedglass";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Reinforced Glass Mod");
        ModBlocks.registerBlocks();
    }
}

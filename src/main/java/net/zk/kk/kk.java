package net.zk.kk;

import net.zk.kk.util.ModRegistries;
import net.fabricmc.api.ModInitializer;

public class kk implements ModInitializer {

    @Override
    public void onInitialize()
    {
        ModRegistries.registerModStuffs();
    }

}

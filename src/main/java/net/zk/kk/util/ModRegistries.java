package net.zk.kk.util;

import net.zk.kk.command.SetHomeCommand;
import net.zk.kk.command.ReturnHome;
import net.zk.kk.event.ModPlayerEventCopyFrom;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

public class ModRegistries {
    public static void registerModStuffs() {
        registerCommands();
        registerEvents();
    }
    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHome::register);
    }

    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }
}

package net.zk.kk.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.zk.kk.util.IEntityDataSaver;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

public class ReturnHome {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("kk")
                .then(CommandManager.literal("home")
                .then(CommandManager.literal("return").executes(ReturnHome::run))));
        // /kk home return
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException{
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();

        int[] homepos = player.getPersistentData().getIntArray("homepos");

        if(homepos.length != 0){
            int[] playerPos = player.getPersistentData().getIntArray("homepos");
            context.getSource().getPlayer().requestTeleport(playerPos[0], playerPos[1], playerPos[2]);

            context.getSource().sendFeedback(new LiteralText("Игрок вернулся домой"), true);
            return 1;
        }
        else {
            context.getSource().sendFeedback(new LiteralText("Позиция дома не найдена"), true);
            return -1;
        }
    }
}

package net.zk.kk.client;

//import kkchat.kkchat.chat.ReciveChatMessage;
import net.zk.kk.screens.BossesScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class kkClient implements ClientModInitializer {
    MinecraftClient client = MinecraftClient.getInstance();
    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient()
    {
        //???
        BossesScreen BossesScreen = new BossesScreen();
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.kkchat.bosses_menu", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_G, // The keycode of the key
                "category.kkchat.main" // The translation key of the keybinding's category.
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                MinecraftClient.getInstance().setScreen(BossesScreen);
            }
        });
    }
}
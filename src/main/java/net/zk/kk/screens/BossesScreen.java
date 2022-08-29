package net.zk.kk.screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;


@Environment(EnvType.CLIENT)
public class BossesScreen extends Screen {

    public BossesScreen()
    {
        super(new LiteralText("Боссы"));
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.fillGradient(matrices, 0, 0, this.width, this.height, 1615855616, -1602211792);
        matrices.push();
        matrices.scale(2.0F, 2.0F, 2.0F);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2 / 2, 5, 16777215);
        matrices.pop();

        drawTextWithShadow(matrices, this.textRenderer, new LiteralText("Древний лучник"), 100, 50, 16777215);
        drawTextWithShadow(matrices, this.textRenderer, new LiteralText("Слизень"), 100 + this.textRenderer.getWidth("Древний лучник") + 100, 50, 16777215);
        drawTextWithShadow(matrices, this.textRenderer, new LiteralText("Страж"), 100 + this.textRenderer.getWidth("Древний лучник") + 100 + this.textRenderer.getWidth("Слизень") + 10, 50, 16777215);

        super.render(matrices, mouseX, mouseY, delta);
    }
}

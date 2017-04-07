package eyeq.cannotturn.event;

import eyeq.cannotturn.CannotTurn;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class CannotTurnEventHandler {
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft minecraft = Minecraft.getMinecraft();
        if(minecraft.currentScreen != null) {
            return;
        }
        EntityPlayerSP player = minecraft.player;
        player.rotationYaw = CannotTurn.rotationYaw;
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft minecraft = Minecraft.getMinecraft();
        if(minecraft.currentScreen != null) {
            return;
        }
        if(CannotTurn.turnKey.isPressed()) {
            CannotTurn.rotationYaw += 90;
            CannotTurn.rotationYaw %= 360;
        }
    }
}

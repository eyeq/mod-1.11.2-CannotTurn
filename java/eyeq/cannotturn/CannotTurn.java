package eyeq.cannotturn;

import eyeq.cannotturn.event.CannotTurnEventHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

import static eyeq.cannotturn.CannotTurn.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class CannotTurn {
    public static final String MOD_ID = "eyeq_cannotturn";

    @Mod.Instance(MOD_ID)
    public static CannotTurn instance;

    public static KeyBinding turnKey = new KeyBinding("key.turn", Keyboard.KEY_L, "CannotTurn");
    public static int rotationYaw = 0;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new CannotTurnEventHandler());
        load(new Configuration(event.getSuggestedConfigurationFile()));
    }
	
    public static void load(Configuration config) {
        config.load();

        String category = "Int";
        int key = config.get(category, "key", turnKey.getKeyCode()).getInt();
        turnKey.setKeyCode(key);
    	
        if(config.hasChanged()) {
            config.save();
        }
    }
}

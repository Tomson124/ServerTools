package de.tomson124.servertools;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import de.tomson124.servertools.commands.memory.CommandMemoryUse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ServerTools.MODID, name = ServerTools.NAME, version = ServerTools.VERSION)
public class ServerTools
{
    public static final String MODID = "servertools";
    public static final String NAME = "Server Tools";
    public static final String VERSION = "@VERSION@";

    public static Logger logger = LogManager.getLogger("ServerTools");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
	    test();
    }

	@EventHandler
	public void serverStarting(FMLServerStartingEvent evt) {
		evt.registerServerCommand(new CommandMemoryUse());
	}

    public void test() {
    	long totalRam = Runtime.getRuntime().totalMemory() / 1024 / 1024;
    	long maxRAM = Runtime.getRuntime().maxMemory() / 1024 / 1024;
    	logger.info("RAM: " + totalRam);
	    logger.info("RAM-ALL: " + maxRAM);
    }
}

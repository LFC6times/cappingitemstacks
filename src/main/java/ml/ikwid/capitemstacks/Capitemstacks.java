package ml.ikwid.capitemstacks;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Capitemstacks implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("capitemstacks");
    @Override
    public void onInitialize() {
        LOGGER.info("capping item stacks");
    }
}

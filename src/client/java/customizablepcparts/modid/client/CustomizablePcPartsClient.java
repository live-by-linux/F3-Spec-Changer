package customizablepcparts.modid.client;

import net.fabricmc.api.ClientModInitializer;

public class CustomizablePcPartsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		SpecCommands.register();
	}

}
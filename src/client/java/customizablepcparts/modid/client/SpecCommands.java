package customizablepcparts.modid.client;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.network.chat.Component;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommands.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal;

public class SpecCommands {

    public static void register() {

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {

            dispatcher.register(
                    literal("cpuedit")
                            .then(argument("cpu", StringArgumentType.greedyString())
                                    .executes(context -> {

                                        CustomSpecs.CPU =
                                                StringArgumentType.getString(context, "cpu");

                                        ConfigManager.save();

                                        context.getSource().sendFeedback(
                                                Component.literal("CPU changed to: " + CustomSpecs.CPU)
                                        );

                                        return 1;
                                    }))
            );

            dispatcher.register(
                    literal("gpuedit")
                            .then(argument("gpu", StringArgumentType.greedyString())
                                    .executes(context -> {

                                        CustomSpecs.GPU =
                                                StringArgumentType.getString(context, "gpu");

                                        ConfigManager.save();

                                        context.getSource().sendFeedback(
                                                Component.literal("GPU changed to: " + CustomSpecs.GPU)
                                        );

                                        return 1;
                                    }))
            );

            dispatcher.register(
                    literal("displayedit")
                            .then(argument("display", StringArgumentType.greedyString())
                                    .executes(context -> {

                                        CustomSpecs.DISPLAY =
                                                StringArgumentType.getString(context, "display");

                                        ConfigManager.save();

                                        context.getSource().sendFeedback(
                                                Component.literal("Display changed to: " + CustomSpecs.DISPLAY)
                                        );

                                        return 1;
                                    }))
            );

            dispatcher.register(
                    literal("driveredit")
                            .then(argument("driver", StringArgumentType.greedyString())
                                    .executes(context -> {

                                        CustomSpecs.DRIVER =
                                                StringArgumentType.getString(context, "driver");

                                        ConfigManager.save();

                                        context.getSource().sendFeedback(
                                                Component.literal("Driver changed to: " + CustomSpecs.DRIVER)
                                        );

                                        return 1;
                                    }))
            );

        });

    }
}
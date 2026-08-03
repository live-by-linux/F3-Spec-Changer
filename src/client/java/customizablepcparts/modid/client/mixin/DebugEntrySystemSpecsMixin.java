package customizablepcparts.modid.client.mixin;

import customizablepcparts.modid.client.CustomSpecs;
import net.minecraft.client.gui.components.debug.DebugEntrySystemSpecs;
import net.minecraft.client.gui.components.debug.DebugScreenDisplayer;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mixin(DebugEntrySystemSpecs.class)
public class DebugEntrySystemSpecsMixin {

    @Redirect(
            method = "display",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/components/debug/DebugScreenDisplayer;addToGroup(Lnet/minecraft/resources/Identifier;Ljava/util/Collection;)V"
            )
    )
    private void customizeSystemSpecs(
            DebugScreenDisplayer displayer,
            Identifier group,
            Collection<String> originalLines
    ) {
        List<String> lines = new ArrayList<>(originalLines);

        // Layout in Minecraft 26.1.2:
        // 0 = Java
        // 1 = CPU
        // 2 = Display
        // 3 = GPU Renderer
        // 4 = Graphics Backend / Driver

        if (lines.size() >= 5) {
            lines.set(1, "CPU: " + CustomSpecs.CPU);
            lines.set(2, "Display: " + CustomSpecs.DISPLAY);
            lines.set(3, "GPU: " + CustomSpecs.GPU);
            lines.set(4, "Driver: " + CustomSpecs.DRIVER);
        }

        displayer.addToGroup(group, lines);
    }
}
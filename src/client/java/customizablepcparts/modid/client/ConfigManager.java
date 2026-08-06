package customizablepcparts.modid.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private static final Path CONFIG_PATH = FabricLoader.getInstance()
            .getConfigDir()
            .resolve("f3-spec-changer.json");

    public static void load() {
        try {
            Files.createDirectories(CONFIG_PATH.getParent());

            if (!Files.exists(CONFIG_PATH)) {
                save();
                return;
            }

            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                SpecConfig config = GSON.fromJson(reader, SpecConfig.class);

                if (config != null) {
                    CustomSpecs.CPU = config.cpu;
                    CustomSpecs.GPU = config.gpu;
                    CustomSpecs.DISPLAY = config.display;
                    CustomSpecs.DRIVER = config.driver;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            Files.createDirectories(CONFIG_PATH.getParent());

            SpecConfig config = new SpecConfig();
            config.cpu = CustomSpecs.CPU;
            config.gpu = CustomSpecs.GPU;
            config.display = CustomSpecs.DISPLAY;
            config.driver = CustomSpecs.DRIVER;

            try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
                GSON.toJson(config, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//hello! (:
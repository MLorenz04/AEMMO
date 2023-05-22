package aeternias.aeternias.handlers;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SerializationHandler {
    public static void serializeCathegories(List<Cathegory> cathegories, String filePath) {
        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        Yaml yaml = new Yaml(options);
        String yamlData = yaml.dump(cathegories);

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(yamlData);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Cathegory> deserializeCathegories(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);

            // Vytvoření instance SnakeYAML
            Yaml yaml = new Yaml();

            // Deserializace objektů z YAML do seznamu
            List<Cathegory> cathegories = yaml.load(reader);

            return cathegories;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void updateYaml(String filePath, int index, int exp) {
        List<Cathegory> list =  deserializeCathegories(filePath);
        list.get(index).setExp(list.get(index).getExp() + exp);
        serializeCathegories(list,filePath);
    }
}

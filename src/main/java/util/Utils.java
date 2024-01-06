package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

public class Utils {
    public static void typeText(Robot robot, String text) {
        char[] characters = text.toCharArray();

        for (char character : characters) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(character);

            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new IllegalArgumentException("Cannot type character: " + character);
            }

            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }

    public static <T> T readJsonFile(String testDataPath, Class<T> valueType) {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(testDataPath));
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonData, valueType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFormattedJsonString(String inputFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read TestData.json file
            File inputFile = new File(inputFilePath);
            JsonNode rootNode = objectMapper.readTree(inputFile);

            // Create a StringBuilder to build the formatted JSON string
            StringBuilder formattedJson = new StringBuilder("{\n");

            // Iterate through the keys in the input JSON
            Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                JsonNode valueNode = entry.getValue();
                String value;

                if (valueNode.isBoolean()) {
                    value = String.valueOf(valueNode.asBoolean());
                } else {
                    value = "\"" + valueNode.asText() + "\"";
                }

                formattedJson.append("    \"").append(entry.getKey()).append("\" : ").append(value);
                if (fields.hasNext()) {
                    formattedJson.append(",\n");
                } else {
                    formattedJson.append("\n");
                }
            }

            formattedJson.append("}");

            return formattedJson.toString();
        } catch (IOException e) {
            // Handle the exception according to your application's requirements
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteAllureReports() {
        String folderPath = System.getProperty("user.dir") + "\\allure-results";
        File folderToDelete = new File(folderPath);
        if (folderToDelete.exists()) {
            try {
                deleteFolder(folderToDelete);
                System.out.println("Allure reports cleared successfully.");
            } catch (SecurityException ignored) {
            }
        }
    }

    public static void deleteFolder(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteFolder(file);
                }
            }
        }
        if (!folder.delete()) {
            System.out.println("Failed to clear folder: " + folder);
        }
    }

}

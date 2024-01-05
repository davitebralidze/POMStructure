package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static void deleteAllureReports() {
        String folderPath = System.getProperty("user.dir") + "\\allure-results";
        File folderToDelete = new File(folderPath);
        if (folderToDelete.exists()) {
            try {
                deleteFolder(folderToDelete);
                System.out.println("Folder and its contents deleted successfully.");
            } catch (SecurityException ignored) {}
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
            System.out.println("Failed to delete folder: " + folder);
        }
    }

}

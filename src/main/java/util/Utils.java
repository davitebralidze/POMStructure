package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.awt.event.KeyEvent;
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
}

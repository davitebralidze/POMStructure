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
            if (Character.isLetterOrDigit(character) || Character.isWhitespace(character)) {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(character);
                if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                    throw new IllegalArgumentException("Cannot type character: " + character);
                }
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
            } else {
                typeSpecialCharacter(robot, character);
            }
        }
    }

    private static void typeSpecialCharacter(Robot robot, char character) {
        switch (character) {
            case '!':
                typeWithShift(robot, KeyEvent.VK_1);
                break;
            case '@':
                typeWithShift(robot, KeyEvent.VK_2);
                break;
            case '#':
                typeWithShift(robot, KeyEvent.VK_3);
                break;
            case '$':
                typeWithShift(robot, KeyEvent.VK_4);
                break;
            case '%':
                typeWithShift(robot, KeyEvent.VK_5);
                break;
            case '^':
                typeWithShift(robot, KeyEvent.VK_6);
                break;
            case '&':
                typeWithShift(robot, KeyEvent.VK_7);
                break;
            case '*':
                typeWithShift(robot, KeyEvent.VK_8);
                break;
            case '(':
                typeWithShift(robot, KeyEvent.VK_9);
                break;
            case ')':
                typeWithShift(robot, KeyEvent.VK_0);
                break;
            case '_':
                typeWithShift(robot, KeyEvent.VK_MINUS);
                break;
            case '+':
                typeWithShift(robot, KeyEvent.VK_EQUALS);
                break;
            case '{':
                typeWithShift(robot, KeyEvent.VK_OPEN_BRACKET);
                break;
            case '}':
                typeWithShift(robot, KeyEvent.VK_CLOSE_BRACKET);
                break;
            case '[':
                robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
                robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
                break;
            case ']':
                robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
                robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
                break;
            case '|':
                typeWithShift(robot, KeyEvent.VK_BACK_SLASH);
                break;
            case ';':
                robot.keyPress(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                break;
            case ':':
                typeWithShift(robot, KeyEvent.VK_SEMICOLON);
                break;
            case '\'':
                robot.keyPress(KeyEvent.VK_QUOTE);
                robot.keyRelease(KeyEvent.VK_QUOTE);
                break;
            case '"':
                typeWithShift(robot, KeyEvent.VK_QUOTE);
                break;
            case '<':
                typeWithShift(robot, KeyEvent.VK_COMMA);
                break;
            case '>':
                typeWithShift(robot, KeyEvent.VK_PERIOD);
                break;
            case ',':
                robot.keyPress(KeyEvent.VK_COMMA);
                robot.keyRelease(KeyEvent.VK_COMMA);
                break;
            case '.':
                robot.keyPress(KeyEvent.VK_PERIOD);
                robot.keyRelease(KeyEvent.VK_PERIOD);
                break;
            case '?':
                typeWithShift(robot, KeyEvent.VK_SLASH);
                break;
            case '/':
                robot.keyPress(KeyEvent.VK_SLASH);
                robot.keyRelease(KeyEvent.VK_SLASH);
                break;
            case '`':
                robot.keyPress(KeyEvent.VK_BACK_QUOTE);
                robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
                break;
            case '~':
                typeWithShift(robot, KeyEvent.VK_BACK_QUOTE);
                break;
            case '-':
                robot.keyPress(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_MINUS);
                break;
            case '=':
                robot.keyPress(KeyEvent.VK_EQUALS);
                robot.keyRelease(KeyEvent.VK_EQUALS);
                break;
            default:
                throw new IllegalArgumentException("Cannot type character: " + character);
        }
    }

    private static void typeWithShift(Robot robot, int keyCode) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
        robot.keyRelease(KeyEvent.VK_SHIFT);
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
            File inputFile = new File(inputFilePath);
            JsonNode rootNode = objectMapper.readTree(inputFile);

            StringBuilder formattedJson = new StringBuilder("{\n");

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

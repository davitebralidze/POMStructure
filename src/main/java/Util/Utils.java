package Util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    private static void typeSpecialCharacter(java.awt.Robot robot, char character) {
        switch (character) {
            case '!' -> typeWithShift(robot, KeyEvent.VK_1);
            case '@' -> typeWithShift(robot, KeyEvent.VK_2);
            case '#' -> typeWithShift(robot, KeyEvent.VK_3);
            case '$' -> typeWithShift(robot, KeyEvent.VK_4);
            case '%' -> typeWithShift(robot, KeyEvent.VK_5);
            case '^' -> typeWithShift(robot, KeyEvent.VK_6);
            case '&' -> typeWithShift(robot, KeyEvent.VK_7);
            case '*' -> typeWithShift(robot, KeyEvent.VK_8);
            case '(' -> typeWithShift(robot, KeyEvent.VK_9);
            case ')' -> typeWithShift(robot, KeyEvent.VK_0);
            case '_' -> typeWithShift(robot, KeyEvent.VK_MINUS);
            case '+' -> typeWithShift(robot, KeyEvent.VK_EQUALS);
            case '{' -> typeWithShift(robot, KeyEvent.VK_OPEN_BRACKET);
            case '}' -> typeWithShift(robot, KeyEvent.VK_CLOSE_BRACKET);
            case '[' -> {
                robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
                robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
            }
            case ']' -> {
                robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
                robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
            }
            case '|' -> typeWithShift(robot, KeyEvent.VK_BACK_SLASH);
            case ';' -> {
                robot.keyPress(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
            }
            case ':' -> typeWithShift(robot, KeyEvent.VK_SEMICOLON);
            case '\'' -> {
                robot.keyPress(KeyEvent.VK_QUOTE);
                robot.keyRelease(KeyEvent.VK_QUOTE);
            }
            case '"' -> typeWithShift(robot, KeyEvent.VK_QUOTE);
            case '<' -> typeWithShift(robot, KeyEvent.VK_COMMA);
            case '>' -> typeWithShift(robot, KeyEvent.VK_PERIOD);
            case ',' -> {
                robot.keyPress(KeyEvent.VK_COMMA);
                robot.keyRelease(KeyEvent.VK_COMMA);
            }
            case '.' -> {
                robot.keyPress(KeyEvent.VK_PERIOD);
                robot.keyRelease(KeyEvent.VK_PERIOD);
            }
            case '?' -> typeWithShift(robot, KeyEvent.VK_SLASH);
            case '/' -> {
                robot.keyPress(KeyEvent.VK_SLASH);
                robot.keyRelease(KeyEvent.VK_SLASH);
            }
            case '`' -> {
                robot.keyPress(KeyEvent.VK_BACK_QUOTE);
                robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
            }
            case '~' -> typeWithShift(robot, KeyEvent.VK_BACK_QUOTE);
            case '-' -> {
                robot.keyPress(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_MINUS);
            }
            case '=' -> {
                robot.keyPress(KeyEvent.VK_EQUALS);
                robot.keyRelease(KeyEvent.VK_EQUALS);
            }
            default -> throw new IllegalArgumentException("Cannot type character: " + character);
        }
    }

    private static void typeWithShift(Robot robot, int keyCode) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
        robot.keyRelease(KeyEvent.VK_SHIFT);
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

//    public static String startAllureServeAndGetPort() {
//        try {
//            String[] command = {"cmd.exe", "/c", "allure serve"};
//            ProcessBuilder processBuilder = new ProcessBuilder(command);
//            processBuilder.redirectErrorStream(true);
//
//            Process process = processBuilder.start();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//
//                // Check if the line contains information about the running server and extract the port
//                if (line.contains("Server started at")) {
//                    String[] parts = line.split(":");
//                    if (parts.length > 2) {
//                        String portString = parts[2].replaceAll("\\D+", "").trim();
//                        final String CYAN = "\u001B[36m";
//                        final String RESET = "\u001B[0m";
//                        final String MAGENTA = "\u001B[35m";
//                        if (!portString.isEmpty()) {
//                            System.out.println(CYAN + "Allure Report is running on a port " + MAGENTA + portString + RESET);
//                            System.out.println(CYAN + "The PID of your process is " + MAGENTA + getPIDOfTheProcess(portString) + RESET);
//                            return portString;
//                        }
//                    }
//                }
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public static String getPIDOfTheProcess(String port) {
//        try {
////            Runtime rt = Runtime.getRuntime();
////            Process proc = rt.exec("cmd /c netstat -ano | findstr " + port);
//            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "netstat", "-ano", "|", "findstr", String.valueOf(port));
//            Process process = processBuilder.start();
//            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//            String s;
//            if ((s = stdInput.readLine()) != null) {
//                int index = s.lastIndexOf(" ");
//                return s.substring(index);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Something Went wrong with server");
//            return null;
//        }
//        return null;
//    }
//
//    public static void killAllureServer(String port, long allureServerActiveTime) {
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "Taskkill", "/PID", getPIDOfTheProcess(port), "/T", "/F");
//            processBuilder.start();
////            Runtime rt = Runtime.getRuntime();
////            rt.exec("cmd /c Taskkill /PID" + getPIDOfTheProcess(port) + " /T /F");
//            Thread.sleep(allureServerActiveTime);
//            JOptionPane.showMessageDialog(null, "The test run has been finished!");
//            final String ORANGE = "\033[93;1m";
//            final String RESET = "\033[0m";
//            System.out.println(ORANGE + "Allure server has been stopped" + RESET);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Something Went wrong with server");
//        }
//    }

    public static void removeElementFromDOM(WebDriver driver, WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].parentNode.removeChild(arguments[0]);", webElement);
    }

    public static void scrollToASpecificElement(WebDriver driver, WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static void scrollByOffset(WebDriver driver, long xOffset, long yOffset) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + xOffset + ", " + yOffset + ")");
    }

    public static void scrollToTheBottomOfThePage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToTheTopOfThePage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0");
    }

    public static void deleteLocalStorage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
    }

    public static void deleteLocalStorage(WebDriver driver, String keyOfElementInLocalStorage) {
        ((JavascriptExecutor) driver).executeScript("window.localStorage.removeItem('" + keyOfElementInLocalStorage + "');");
    }

    public static void exportAllureResultAsHTML() {

        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";

        // Specify the path to your project directory
        String projectDirectoryPath = System.getProperty("user.dir");

        // Append "allure-history" to the project directory path
        String allureHistoryFolderPath = projectDirectoryPath + File.separator + "allure-history";

        // Create a File object for the allure-history folder
        File allureHistoryFolder = new File(allureHistoryFolderPath);

        // Check if the allure-history folder exists
        if (!allureHistoryFolder.exists()) {
            // Create the allure-history folder
            boolean created = allureHistoryFolder.mkdir();
            if (created) {
                System.out.println("allure-history folder created.");
            }
        }

        //Code below (till the next notice) creates a folder with name of specific date and time to store HTML of allure

        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the format for the folder name
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        // Format the current date and time according to the specified format
        String folderName = currentDateTime.format(formatter);

        // Specify the path where you want to create the folder
        String parentDirectory = "allure-history";

        // Create the full path for the new folder
        String folderPath = parentDirectory + File.separator + folderName;

        // Create the folders
        Path htmlFolderPath = null;
        Path allureFilesFolderPath = null;
        try {
            // Create the folder for the specific date and time
            Path folder = Files.createDirectories(Paths.get(folderPath));
            // Create the HTML subfolder
            htmlFolderPath = Files.createDirectories(folder.resolve("HTML"));
            // Create the allure-files subfolder
            allureFilesFolderPath = Files.createDirectories(folder.resolve("allure-report"));
        } catch (Exception e) {
            System.err.println(RED + "Failed to create folder: " + e.getMessage() + RESET);
        }

        //From here we are generating Allure HTML file in a created file

        try {
            // Define the command to execute
            String[] command = {"cmd.exe", "/c", "allure", "generate", "allure-results", "-o", String.valueOf(htmlFolderPath)};

            // Start a new process builder
            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // Redirect any output to the console
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to finish
            process.waitFor();

            // Check if the process exited with an error
            int exitValue = process.exitValue();
            if (exitValue != 0) {
                System.err.println(RED + "Error: Allure process exited with non-zero exit code: " + exitValue + RESET);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


        Path sourcePath = Paths.get("allure-results");
        Path destinationPath = Paths.get(String.valueOf(allureFilesFolderPath));

        // Copy the source folder to the destination folder
        try {
            Files.walk(sourcePath)
                    .forEach(source -> {
                        Path destination = destinationPath.resolve(sourcePath.relativize(source));
                        try {
                            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

}

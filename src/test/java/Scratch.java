import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Scratch {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the format for the folder name
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        // Format the current date and time according to the specified format
        String folderName = currentDateTime.format(formatter);

        // Specify the path where you want to create the folder
        String parentDirectory = "allure-history"; // Replace with your desired parent directory

        // Create the full path for the new folder
        String folderPath = parentDirectory + File.separator + folderName;

        // Create the folder
        Path folder = Paths.get(folderPath);
        try {
            Files.createDirectories(folder);
            System.out.println("Folder created: " + folder);
        } catch (Exception e) {
            System.err.println("Failed to create folder: " + e.getMessage());
        }
    }
}

package ExecuteGUI;

import Util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class MyGuiApp {

    static String port;

    private static JTextArea consoleTextArea; // JTextArea for console output
    private static StringWriter consoleWriter; // StringWriter to capture console output

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("My GUI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Utils.killAllureServer(port);
            }
        });
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridBagLayout());

        // Create the environment dropdown
        String[] environments = {"QA", "UAT", "Live"};
        JComboBox<String> environmentDropdown = new JComboBox<>(environments);

        // Create the browser dropdown
        String[] browsers = {"Chrome", "FireFox", "Opera", "Edge"};
        JComboBox<String> browserDropdown = new JComboBox<>(browsers);

        // Create the buttons
        JButton lastExecutionButton = new JButton("Test Result");
        JButton pullLatestButton = new JButton("Pull Latest");
        JButton executeTestsButton = new JButton("Execute Tests");

        // Add action listeners to buttons
        executeTestsButton.addActionListener(e -> executeTests(browserDropdown.getSelectedItem(), environmentDropdown.getSelectedItem()));
        lastExecutionButton.addActionListener(e -> showTestResults());
        pullLatestButton.addActionListener(e -> pullLatest());

        // Add components to the frame using GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(new JLabel("Environment:"), gbc);

        gbc.gridx = 1;
        frame.add(environmentDropdown, gbc);

        gbc.gridx = 2;
        frame.add(new JLabel("Browser:"), gbc);

        gbc.gridx = 3;
        frame.add(browserDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(lastExecutionButton, gbc);

        gbc.gridx = 1;
        frame.add(pullLatestButton, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2; // Adjust grid width for Execute Tests button
        frame.add(executeTestsButton, gbc);

        // Initialize the JTextArea for console output
        consoleTextArea = new JTextArea();
        consoleTextArea.setEditable(false);
        JScrollPane consoleScrollPane = new JScrollPane(consoleTextArea);

        gbc.gridx = 0;
        gbc.gridy = 4; // Adjust the row index as needed
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        frame.add(consoleScrollPane, gbc);

        // Display the frame
        frame.setVisible(true);

        // Redirect System.out to consoleTextArea using CustomOutputStream
        consoleWriter = new StringWriter();
        PrintStream printStream = new PrintStream(new CustomOutputStream(consoleTextArea));
        System.setOut(printStream);
    }

    private static void executeTests(Object browser, Object environment) {
        // Ensure browser and environment are not null
        if (browser == null || environment == null) {
            JOptionPane.showMessageDialog(null, "Please select browser and environment.");
            return;
        }

        // Execute Maven command: mvn test -DsuiteFile=testng.xml -Dbrowser=<browser> -Denvrionment=<environment>
        try {
            String[] command = {"cmd.exe", "/c", "mvn test -D suiteFile=testng.xml -D browser=" + browser.toString().toLowerCase() + " -D envrionment=" + environment.toString().toLowerCase()};
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Read output from process and display in consoleTextArea
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                consoleTextArea.append(line + "\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            consoleTextArea.append("\n\nTests execution completed with exit code: " + exitCode + "\n");

        } catch (IOException | InterruptedException e) {
            consoleTextArea.append("Error executing Maven command: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    private static void showTestResults() {
        port = Utils.startAllureServeAndGetPort();
    }

    private static void pullLatest() {
        // Execute git pull command
        try {
            String[] command = {"cmd.exe", "/c", "git pull"};
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Read output from process and display in consoleTextArea
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                consoleTextArea.append(line + "\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            consoleTextArea.append("\n\nGit pull completed with exit code: " + exitCode + "\n");

        } catch (IOException | InterruptedException e) {
            consoleTextArea.append("Error executing git pull command: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    // CustomOutputStream to redirect System.out to JTextArea
    private static class CustomOutputStream extends OutputStream {
        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            // Redirects data to the text area
            textArea.append(String.valueOf((char) b));
            // Scrolls the text area to the end of data
            textArea.setCaretPosition(textArea.getDocument().getLength());
            // Write to consoleWriter to capture output
            consoleWriter.write(b);
        }
    }

}

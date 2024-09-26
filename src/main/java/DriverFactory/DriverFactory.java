package DriverFactory;

public class DriverFactory {
    public static BrowserDriver getDriver(String browserType) {
        return switch (browserType.toLowerCase()) {
            case "chrome" -> new ChromeDriverManager();
            case "firefox" -> new FireFoxDriverManager();
            case "edge" -> new EdgeDriverManager();
            default -> throw new IllegalArgumentException("Invalid browser type passed: "+browserType);
        };
    }
}
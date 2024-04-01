import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class HandlingDownloadDirectory {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        Map<String , Object> prefs = new HashMap<String , Object>();
        prefs.put("download.default_directory" , "Downloads");
    }
}

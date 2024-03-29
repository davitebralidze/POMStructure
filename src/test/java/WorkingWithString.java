import java.util.Arrays;

public class WorkingWithString {

    public static void main(String[] args) {
        String stringToWorkOn = "Hello, I'm robot and my email is robot@email.com and you can write to me here";
        System.out.println(stringToWorkOn.split("is")[1].split("and")[0].trim());
    }
}

import java.util.Arrays;

public class WorkingWithString {

    public static void main(String[] args) {
        String stringToWorkOn = "Hello, I'm robot and my email is robot@email.com and you can write to me here";
        System.out.println(stringToWorkOn.split("is")[1].split("and")[0].trim());
        //split() functions splits the string in array of strings (removes the string by which we split the text)
        //trim() removes extra white spaces at the beginning and end
    }
}

import util.Utils;

public class GiveDataFromJSON {

    public static void main(String[] args) {

        String requestBody = "{\n" + "    \"Email\" : \"0713georgia@gmail.com\",\n" + "    \"Password\" : \"Gagoshidze1!\",\n" + "    \"RememberMe\" : false\n" + "}";

        String json = Utils.getFormattedJsonString("C:\\Users\\Davit\\IdeaProjects\\POMStructure\\src\\main\\java\\testdata\\TestData.json");


        System.out.println(json);
        System.out.println(requestBody);

        System.out.println(requestBody.equals(json));

    }

}





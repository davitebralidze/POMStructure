import PojoClass.Address;
import PojoClass.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadingDataJackson {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/java/JsonData/Employee.json");

        //Read JSON data from the file and map to Person class
        Person person = objectMapper.readValue(file, Person.class);


        List<Address> addresses = person.getAddress();
        Address firstAddress = addresses.get(0);
        Address secondAddress = addresses.get(1);

        System.out.println(firstAddress.getStreet());
        System.out.println(secondAddress.getStreet());

    }

}

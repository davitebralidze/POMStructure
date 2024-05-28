import PojoClass.Address;
import PojoClass.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadingDataJackson {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/java/JsonData/Employee.json");

        //Read JSON data from the file and map to Person class
        Person person = objectMapper.readValue(file, Person.class);

        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
        for(Address address : person.getAddress()) {
            System.out.println(address.getStreet());
            System.out.println(address.getCity());
            System.out.println(address.getState());
        }

    }

}

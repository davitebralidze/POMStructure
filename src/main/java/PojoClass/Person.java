package PojoClass;

import lombok.Data;

import java.util.List;

@Data
public class Person {

    String firstName;
    String lastName;
    List<Address> address;

}

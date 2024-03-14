import com.github.javafaker.Faker;

public class JavaFaker {

    public static void main(String[] args) {

        Faker faker = new Faker();

        String
                firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                nation = faker.nation().nationality(),
                address = faker.address().fullAddress();

    }
}

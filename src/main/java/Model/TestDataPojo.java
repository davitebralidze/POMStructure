package Model;

import lombok.Data;

@Data /*lombok annotation that creates both, setters and getters*/
public class TestDataPojo {
    //    @JsonProperty("Email") -- > In case the name differs in the json format data provider file
    private String Email;
    private String Password;
    private String RememberMe;

}

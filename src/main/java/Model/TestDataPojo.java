package Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDataPojo {
//    @JsonProperty("Email") -- > In case the name differs in the json format data provider file
    private String email;
    private String password;
    private boolean rememberMe;

}

package Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDataPojo {
    String Email;
    String Password;
    boolean RememberMe;
}

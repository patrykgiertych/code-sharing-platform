package codesharing.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegistrationRequest {
    private final String username;
    private final String password;
}

package codesharing.registration;

import codesharing.user.User;
import codesharing.user.UserRole;
import codesharing.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final UserValidator userValidator;


    public String register(RegistrationRequest request) {
        boolean isValid = userValidator.test(request.getUsername());
        if (!isValid) {
            throw new IllegalStateException("not valid");
        }
        return userService.signUpUser(
                new User(
                        request.getUsername(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}

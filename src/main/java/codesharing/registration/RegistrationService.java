package codesharing.registration;

import codesharing.user.User;
import codesharing.user.UserRole;
import codesharing.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserService userService;

    @Autowired
    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public User register(RegistrationRequest request) {
        if (userService.getUser(request.getUsername()) != null) {
            return null;
        }

        User user = new User(
                request.getUsername(),
                request.getPassword(),
                UserRole.USER
        );

        userService.register(user);

        return user;
    }
}

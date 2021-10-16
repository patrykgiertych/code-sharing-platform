package codesharing.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    private final List<User> USERLIST = Arrays.asList(                         // for testing
            new User("user1", "password1"),
            new User("user2", "password2"),
            new User("user3", "password3")
    );

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/api/user/new")
    @ResponseBody
    public User register(@RequestBody User user) {
        userService.register(user);
        return user;
    }

    @GetMapping("/admin/api/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

package codesharing.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;


}

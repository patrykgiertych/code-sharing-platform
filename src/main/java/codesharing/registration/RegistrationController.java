package codesharing.registration;

import codesharing.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/api/user/new")
    @ResponseBody
    public User register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping("/register")
    public String registerHTML() {
        return "register";
    }

}

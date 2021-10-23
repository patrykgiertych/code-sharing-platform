package codesharing.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{username}/code")
    public String getAllCode(Model model, @PathVariable String username) {
        User user = userService.getUser(username);
        model.addAttribute("codeList", user.getCodeList());
        return "user_snippets";
    }

}

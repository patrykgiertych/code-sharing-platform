package codesharing.controller;

import codesharing.code.Code;
import codesharing.code.CodeService;
import codesharing.user.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class TemplateController {

    private final CodeService codeService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerHTML() {
        return "register";
    }

    @GetMapping("/code/new")
    public String sendCode() {
        return "new_code";
    }

    @GetMapping("/code/{id}")
    public String getCodeInHtml(@PathVariable Long id, Model model) {
        model.addAttribute("snippet", codeService.getCode(id));
        return "view_snippet";
    }

    @GetMapping("/your_profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        return "your_profile";
    }
}

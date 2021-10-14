package codesharing.code;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CodeController {

    private final CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @PostMapping("/api/code/new")
    @ResponseBody
    public CodeDto addCode(@RequestBody CodeDto code) {
        codeService.addNewCode(code);
        return code;
    }

    @GetMapping("/api/code/{id}")
    @ResponseBody
    public Code getCode(@PathVariable String id) {
        return codeService.getCode(id);
    }

    @GetMapping("/code/new")
    public String sendCode() {
        return "new_code";
    }

    @GetMapping("/code/{id}")
    public String getCodeInHtml(@PathVariable String id, Model model) {
        model.addAttribute("snippet", codeService.getCode(id));
        return "view_snippet";
    }
}

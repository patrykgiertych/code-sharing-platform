package codesharing.code;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @PostMapping("/api/code/new")
    @ResponseBody
    public CodeDto addCode(@RequestBody CodeDto code) {
        codeService.addNewCode(code);
        return code;
    }

    @GetMapping("/api/code/{id}")
    @ResponseBody
    public Code getCode(@PathVariable Long id) {
        return codeService.getCode(id);
    }

}

package codesharing.code;

import codesharing.user.User;

import codesharing.util.Utility;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CodeService {

    private final CodeRepository codeRepository;
    private final Utility util;

    public void addNewCode(CodeDto code) {
        User user = util.getLoggedUser();
        Code newCode = new Code(code);
        user.addCode(newCode);
        codeRepository.save(newCode);
    }

    public Code getCode(Long id) {
        return codeRepository.findCodeById(id);
    }
}

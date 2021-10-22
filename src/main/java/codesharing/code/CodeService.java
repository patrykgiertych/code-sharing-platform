package codesharing.code;

import codesharing.user.User;
import codesharing.user.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CodeService {

    private final CodeRepository codeRepository;
    private final UserRepository userRepository;

    public void addNewCode(CodeDto code, User user) {
        Code newCode = new Code(code);
        user.addCode(newCode);
        codeRepository.save(newCode);
    }

    public Code getCode(Long id) {
        return codeRepository.findCodeById(id);
    }
}

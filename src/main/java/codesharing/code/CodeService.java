package codesharing.code;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CodeService {

    private final CodeRepository codeRepository;

    public void addNewCode(CodeDto code) {
        Code newCode = new Code(code);
        codeRepository.save(newCode);
    }

    public Code getCode(String id) {
        return codeRepository.findCodeById(id);
    }
}

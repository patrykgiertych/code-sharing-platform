package codesharing.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public void addNewCode(CodeDto code) {
        Code newCode = new Code(code);
        codeRepository.save(newCode);
    }

    public Code getCode(String id) {
        return codeRepository.findCodeById(id);
    }
}

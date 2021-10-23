package codesharing.code;

import codesharing.user.User;
import codesharing.user.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CodeService {

    private final CodeRepository codeRepository;
    private final UserRepository userRepository;

    public void addNewCode(CodeDto code) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userRepository.findByUsername(username).get();
        Code newCode = new Code(code);
        user.addCode(newCode);
        codeRepository.save(newCode);
    }

    public Code getCode(Long id) {
        return codeRepository.findCodeById(id);
    }
}

package codesharing.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        if (userRepository.existsById(id)) {
            return userRepository.findUserById(id);
        }
        return null;
    }

    public User getUser(String username) {
        if (userRepository.findUserByUsernameOptional(username).isPresent()) {
            return userRepository.findUserByUsername(username);
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(s);
    }

    public void register(User user) {
        userRepository.save(user);
    }
}

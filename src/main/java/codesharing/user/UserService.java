package codesharing.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public String signUpUser(User user) {
        boolean userExists = userRepository.findByUsername(user.getUsername())
                .isPresent();
        if (userExists) {
            throw new IllegalStateException("already taken");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "signUpUser works";
    }

    public User getUser(String username) throws UsernameNotFoundException {
        if (!userRepository.findByUsername(username).isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return userRepository.findByUsername(username).get();
    }
}

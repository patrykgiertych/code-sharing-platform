package codesharing.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class UserValidator implements Predicate<String> {

    @Override
    public boolean test(String username) {
        // TODO: validate username
        return true;
    }
}

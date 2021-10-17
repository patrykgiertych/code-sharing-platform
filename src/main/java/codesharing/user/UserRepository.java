package codesharing.user;

import codesharing.code.Code;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    @Query("select u from User u where u.id = ?1")
    User findUserById(Long id);

    @Query(value = "select * from User ", nativeQuery = true)
    List<User> getAllUsers();

    @Query("select u from User u where u.username = ?1")
    User findUserByUsername(String username);

    @Query("select u from User u where u.username = ?1")
    Optional<User> findUserByUsernameOptional(String username);

}

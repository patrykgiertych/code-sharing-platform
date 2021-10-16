package codesharing.user;

import codesharing.code.Code;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    @Query("select u from User u where u.id = ?1")
    User findUserById(Long id);

    @Query(value = "select * from User ", nativeQuery = true)
    List<User> getAllUsers();
}

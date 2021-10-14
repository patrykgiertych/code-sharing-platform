package codesharing.code;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends CrudRepository<Code, String> {

    @Query("select c from Code c where c.id = ?1")
    Code findCodeById(String id);
}

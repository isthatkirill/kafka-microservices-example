package isthatkirill.datastatistics.repository;

import isthatkirill.datastatistics.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kirill Emelyanov
 */

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {

}

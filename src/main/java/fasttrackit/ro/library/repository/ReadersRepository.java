package fasttrackit.ro.library.repository;

import fasttrackit.ro.library.model.entity.Readers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReadersRepository extends JpaRepository<Readers, Integer> {

    @Query(value = "SELECT * FROM Readers  WHERE first_name iLIKE %:keyword% or last_name iLIKE %:keyword% ORDER BY readers.reader_id ASC", nativeQuery = true)
    List<Readers> findByKeyword(@Param("keyword") String keyword);
}
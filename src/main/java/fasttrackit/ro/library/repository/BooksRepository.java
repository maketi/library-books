package fasttrackit.ro.library.repository;


import fasttrackit.ro.library.model.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Integer> {

    @Query(value = "SELECT * FROM Books  WHERE title iLIKE %:keyword% ORDER BY books.book_id ASC", nativeQuery = true)
    List<Books> findByKeyword(@Param("keyword") String keyword);
}

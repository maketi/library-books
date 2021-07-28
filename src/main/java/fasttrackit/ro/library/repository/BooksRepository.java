package fasttrackit.ro.library.repository;

import fasttrackit.ro.library.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {
}

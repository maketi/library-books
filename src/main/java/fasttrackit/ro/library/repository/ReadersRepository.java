package fasttrackit.ro.library.repository;

import fasttrackit.ro.library.entity.Readers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Reader;

public interface ReadersRepository extends JpaRepository<Readers, Integer> {
}

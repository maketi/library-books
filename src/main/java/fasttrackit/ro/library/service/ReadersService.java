package fasttrackit.ro.library.service;

import fasttrackit.ro.library.entity.Readers;
import fasttrackit.ro.library.repository.ReadersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadersService {
    private final ReadersRepository repository;

    public ReadersService(ReadersRepository repository) {
        this.repository = repository;
    }

    public List<Readers> getAll() {
        return repository.findAll();
    }
}

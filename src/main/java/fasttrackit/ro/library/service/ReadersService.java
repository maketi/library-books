package fasttrackit.ro.library.service;

import fasttrackit.ro.library.entity.Readers;
import fasttrackit.ro.library.repository.ReadersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadersService {
    private final ReadersRepository repository;

    public ReadersService(ReadersRepository repository) {
        this.repository = repository;
    }

    public List<Readers> getAll() {
        return repository.findAll();
    }

    public Readers createReader(Readers readers) {
        return repository.saveAndFlush(readers);
    }

    public void deleteReaders(Integer readersId) {
        boolean findReader = repository.existsById(readersId);
        if (!findReader) {
            throw new IllegalStateException("Reader with id: " + readersId + " does not exist");
        }
        repository.deleteById(readersId);
    }

    public Readers updateReaders(Integer readersId, Readers newReader) {
        Optional<Readers> existingReader = repository.findById(readersId);
        if (!existingReader.isPresent()) {
            throw new IllegalStateException("Reader not found");
        }
        Readers result = existingReader.get();
        result.setReaderId(result.getReaderId());
        result.setLibraryCard(result.getLibraryCard());
        result.setFirstName(newReader.getFirstName() != null ? newReader.getFirstName() : result.getFirstName());
        result.setLastName(newReader.getLastName() != null ? newReader.getLastName() : result.getLastName());
        result.setAddress(newReader.getAddress() != null ? newReader.getAddress() : result.getAddress());
        result.setEmail(newReader.getEmail() != null ? newReader.getEmail() : result.getEmail());
        result.setPhone(newReader.getPhone() != null ? newReader.getPhone() : result.getPhone());
        return repository.save(result);
    }
}

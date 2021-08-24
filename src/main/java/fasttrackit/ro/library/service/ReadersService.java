package fasttrackit.ro.library.service;

import fasttrackit.ro.library.model.entity.Readers;
import fasttrackit.ro.library.repository.ReadersRepository;
import org.springframework.data.domain.Sort;
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
        return repository.findAll(Sort.by(Sort.Direction.ASC, "readerId"));
    }

    public Readers addReader(Readers newReader) {
        return repository.save(newReader);
    }

    public Readers deleteReaders(Integer readersId) {
        Optional<Readers> reader = repository.findById(readersId);
        reader.ifPresent(repository::delete);
        return reader.orElse(null);
    }

    public Optional<Readers> replaceReader(int readerId, Readers readers) {
        return repository.findById(readerId)
                .map(dbReader -> patchReader(dbReader, readers))
                .map(repository::save);
    }

    public Readers patchReader(Readers dbReader, Readers readers) {
        dbReader.setFirstName(readers.getFirstName());
        dbReader.setLastName(readers.getLastName());
        dbReader.setLibraryCard(readers.getLibraryCard());
        dbReader.setAddress(readers.getAddress());
        dbReader.setEmail(readers.getEmail());
        dbReader.setPhone(readers.getPhone());
        return dbReader;
    }

    public List<Readers> findByKeyword(String keyword) {
        return repository.findByKeyword(keyword);
    }


    public Optional<Readers> getReader(int readerId) {
        return repository.findById(readerId);
    }
}
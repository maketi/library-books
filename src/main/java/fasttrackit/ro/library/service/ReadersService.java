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

    public Readers addReader(Readers newReader) {

        return repository.saveAndFlush(newReader);
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
}

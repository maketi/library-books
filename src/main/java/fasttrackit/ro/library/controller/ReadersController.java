package fasttrackit.ro.library.controller;

import fasttrackit.ro.library.model.entity.Readers;
import fasttrackit.ro.library.service.ReadersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/library/readers")
public class ReadersController {
    private final ReadersService readersService;

    public ReadersController(ReadersService readersService) {
        this.readersService = readersService;
    }

    @GetMapping
    public List<Readers> getAll() {
        return readersService.getAll();
    }

    @PostMapping
    Readers addReader(@RequestBody Readers newReader) {
        newReader.setReaderId(null);
        return readersService.addReader(newReader);
    }

    @PatchMapping("{readersId}")
    public Optional<Readers> updateReaders(@PathVariable Integer readersId,
                                           @RequestBody Readers readers) {
        return readersService.replaceReader(readersId, readers);
    }

    @DeleteMapping("{readersId}")
    public Readers deleteReaders(@PathVariable Integer readersId) {
        return readersService.deleteReaders(readersId);
    }
}
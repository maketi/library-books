package fasttrackit.ro.library.controller;

import fasttrackit.ro.library.entity.Readers;
import fasttrackit.ro.library.service.ReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/readers/data")
public class ReadersController {
    @Autowired
    private final ReadersService readersService;

    public ReadersController(ReadersService readersService) {
        this.readersService = readersService;
    }

    @GetMapping
    public List<Readers> getAll() {
        return readersService.getAll();
    }

    @PostMapping
    Readers createReader(@RequestBody Readers readers) {
        return readersService.createReader(readers);
    }

    @PatchMapping("{readersId}")
    public Readers updateReaders(@PathVariable Integer readersId,
                                 @RequestBody Readers newReader) {
        return readersService.updateReaders(readersId, newReader);
    }

    @DeleteMapping("{readersId}")
    void deleteReaders(@PathVariable Integer readersId) {
        readersService.deleteReaders(readersId);
    }
}


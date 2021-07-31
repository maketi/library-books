package fasttrackit.ro.library.controller;

import fasttrackit.ro.library.entity.Readers;
import fasttrackit.ro.library.service.ReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}


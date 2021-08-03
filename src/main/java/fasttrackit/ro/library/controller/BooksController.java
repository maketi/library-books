package fasttrackit.ro.library.controller;

import fasttrackit.ro.library.entity.Books;
import fasttrackit.ro.library.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/books/data")
public class BooksController {
    @Autowired
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<Books> getAllBooks() {
        return booksService.getAll();
    }

    @PostMapping
    Books createBook(@RequestBody Books books) {
        return booksService.createBook(books);
    }

    @PatchMapping("{booksId}")
    public Books updateBooks(@PathVariable Integer booksId,
                             @RequestBody Books newBook) {
        return booksService.updateBooks(booksId, newBook);
    }

    @DeleteMapping("{booksId}")
    void deleteBooks(@PathVariable Integer booksId) {
        booksService.deleteBooks(booksId);
    }
}

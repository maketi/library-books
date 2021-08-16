package fasttrackit.ro.library.controller;


import fasttrackit.ro.library.model.entity.Books;
import fasttrackit.ro.library.service.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/library/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping
    Books addBook(@RequestBody Books newBook) {
        newBook.setBookId(null);
        return booksService.addBook(newBook);
    }

    @PatchMapping("{booksId}")
    public Optional<Books> updateBook(@PathVariable Integer booksId,
                                      @RequestBody Books books) {
        return booksService.replaceBook(booksId, books);
    }

    @DeleteMapping("{booksId}")
    Books deleteBooks(@PathVariable int booksId) {
        return booksService.deleteBook(booksId);
    }
}

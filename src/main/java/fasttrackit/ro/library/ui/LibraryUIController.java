package fasttrackit.ro.library.ui;


import fasttrackit.ro.library.service.BooksService;
import fasttrackit.ro.library.service.ReadersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.util.Optional.ofNullable;

@Controller
@RequestMapping("library")
public class LibraryUIController {
    private final BooksService booksService;
    private final ReadersService readersService;

    public LibraryUIController(BooksService booksService, ReadersService readersService) {
        this.booksService = booksService;
        this.readersService = readersService;
    }

    @GetMapping("/books")
    String booksPage(Model model, String keyword) {
        if (keyword != null) {
            model.addAttribute("books", booksService.findByKeyword(keyword));
        } else {
            model.addAttribute("books", booksService.getAll());
        }
        return "books";
    }

    @GetMapping("/books/{bookId}")
    String singleBookPage(@PathVariable int bookId, Model pageModel) {
        pageModel.addAttribute("book", booksService.getBook(bookId).orElse(null));

        return "single-book";
    }

    @GetMapping("/readers")
    String readersPage(Model model, @RequestParam(required = false) Integer showReader, String keyword) {
        if (keyword != null) {
            model.addAttribute("readers", readersService.findByKeyword(keyword));

        } else {
            model.addAttribute("readers", readersService.getAll());
            ofNullable(showReader)
                    .flatMap(readersService::getReader)
                    .ifPresent(readers -> model.addAttribute("showReader", readers));
        }
        return "readers";
    }

    @GetMapping()
    String firstPage() {
        return "library";
    }

    @GetMapping("/borrowedBooks")
    String borrowedBooksPage() {
        return "borrowedBooks";
    }

    @GetMapping("/info")
    String infoPage() {
        return "contact";
    }
}
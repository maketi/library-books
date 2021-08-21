package fasttrackit.ro.library.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fasttrackit.ro.library.service.BooksService;

import static java.util.Optional.ofNullable;

@Controller
@RequestMapping("library")
public class BooksUIController {
    private final BooksService service;

    public BooksUIController(BooksService booksService) {
        this.service = booksService;
    }

    @GetMapping("/books")
    String booksPage(Model model, @RequestParam(required = false) Integer showBook, String keyword) {
        if (keyword != null) {
            model.addAttribute("books", service.findByKeyword(keyword));
        } else {
            model.addAttribute("books", service.getAll());
            ofNullable(showBook)
                    .flatMap(service::getBook)
                    .ifPresent(books -> model.addAttribute("showBook", books));
        }
        return "books";
    }

    @GetMapping("/books/{bookId}")
    String singleBookPage(@PathVariable int bookId, Model pageModel) {
        pageModel.addAttribute("book", service.getBook(bookId).orElse(null));

        return "single-book";
    }

    @GetMapping()
    String firstPage() {
        return "library";
    }
}
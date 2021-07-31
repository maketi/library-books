package fasttrackit.ro.library.ui;

import fasttrackit.ro.library.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library/books")
public class BooksUIController {
    private final BooksService service;

    public BooksUIController(BooksService booksService) {
        this.service = booksService;
    }

    @GetMapping
    String booksPage(Model model) {
        model.addAttribute("books", service.getAll());
        return "books";
    }
}
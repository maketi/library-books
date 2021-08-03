package fasttrackit.ro.library.ui;

import fasttrackit.ro.library.service.ReadersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library/readers")
public class ReadersUIController {

    private final ReadersService service;

    public ReadersUIController(ReadersService service) {
        this.service = service;
    }

    @GetMapping
    String booksPage(Model model) {
        model.addAttribute("readers", service.getAll());
        return "readers";
    }


}
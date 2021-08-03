package fasttrackit.ro.library.service;

import fasttrackit.ro.library.entity.Books;
import fasttrackit.ro.library.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> getAll() {
        return booksRepository.findAll();
    }

    public Books createBook(Books books) {
        return booksRepository.saveAndFlush(books);
    }

    public Books updateBooks(Integer booksId, Books newBook) {
        Optional<Books> existingBook = booksRepository.findById(booksId);
        if (!existingBook.isPresent()) {
            throw new IllegalStateException("Book with " + booksId + " not found");
        }
        Books result = existingBook.get();
        result.setBookId(result.getBookId());
        result.setTitle(newBook.getTitle() != null ? newBook.getTitle() : result.getTitle());
        result.setAuthor(newBook.getAuthor() != null ? newBook.getAuthor() : result.getAuthor());
        result.setAmount(newBook.getAmount() > 0 ? newBook.getAmount() : result.getAmount());
        result.setCategory(result.getCategory());
        result.setPublisher(newBook.getPublisher() != null ? newBook.getPublisher() : result.getPublisher());
        result.setYear(newBook.getYear() > 0 && newBook.getYear() < 2022 ? newBook.getYear() : result.getYear());
        return booksRepository.save(result);
    }

    public void deleteBooks(Integer booksId) {
        boolean findBook = booksRepository.existsById(booksId);
        if (!findBook) {
            throw new IllegalStateException("Book with id: " + booksId + " not found");
        }
        booksRepository.deleteById(booksId);
    }
}

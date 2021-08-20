package fasttrackit.ro.library.service;


import fasttrackit.ro.library.model.entity.Books;
import fasttrackit.ro.library.repository.BooksRepository;
import org.springframework.data.domain.Sort;
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
        return booksRepository.findAll(Sort.by(Sort.Direction.ASC, "bookId"));
    }

    public Books addBook(Books newBook) {
        return booksRepository.saveAndFlush(newBook);
    }

    public Books deleteBook(int booksId) {
        Optional<Books> book = booksRepository.findById(booksId);
        book.ifPresent(booksRepository::delete);
        return book.orElse(null);
    }

    private Books patchBook(Books dbBook, Books books) {
        dbBook.setTitle(books.getTitle());
        dbBook.setAuthor(books.getAuthor());
        dbBook.setAmount(books.getAmount());
        dbBook.setCategory(books.getCategory());
        dbBook.setAmount(books.getAmount());
        dbBook.setPublisher(books.getPublisher());
        dbBook.setYear(books.getYear());
        dbBook.setImage(books.getImage());
        return dbBook;
    }

    public Optional<Books> replaceBook(int booksId, Books books) {
        return booksRepository.findById(booksId)
                .map(dbBook -> patchBook(dbBook, books))
                .map(booksRepository::save);
    }

    public Optional<Books> getBook(int booksId) {
        return booksRepository.findById(booksId);
    }

    public List<Books> findByKeyword(String keyword) {
        return booksRepository.findByKeyword(keyword);
    }
}
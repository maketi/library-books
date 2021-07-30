package fasttrackit.ro.library.entity;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "books")
public class Books {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long bookId;

    private String author;
    private String title;
    @Enumerated(STRING)
    private Category category;
    @OneToOne(cascade = ALL)
     @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    private double price;

    public Books() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", publisher=" + publisher +
                ", price=" + price +
                '}';
    }
}


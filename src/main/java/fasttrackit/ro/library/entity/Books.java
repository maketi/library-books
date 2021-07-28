package fasttrackit.ro.library.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "books")
public class Books {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long bookId;

    private String author;
    private String title;
    private String category;
    @Column(name = "publisher_id")
    private int publisherId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", publisherId=" + publisherId +
                ", price=" + price +
                '}';
    }
}


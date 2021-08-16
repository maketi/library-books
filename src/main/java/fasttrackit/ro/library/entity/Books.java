package fasttrackit.ro.library.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = IDENTITY)
    private Integer bookId;
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    @Enumerated(STRING)
    private Category category;
    @Min(value = 1)
    private int amount;
    private String publisher;
    @Min(value = 1)
    @Max(value = 2021)
    private int year;
    @Column(name = "url_image")
    private String image;

    @ManyToMany
    private List<Readers> readers;

    public Books() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Readers> getReaders() {
        return readers;
    }

    public void setReaders(List<Readers> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", amount=" + amount +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", image='" + image + '\'' +
                ", readers=" + readers +
                '}';
    }
}
package fasttrackit.ro.library.model.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "readers")
public class Readers {
    @Id
    @Column(name = "reader_id")
    @GeneratedValue(strategy = IDENTITY)
    private Integer readerId;
    @NotEmpty
    @Column(name = "card_id")
    private Integer libraryCard;
    @NotEmpty
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty
    private String address;
    @NotEmpty
    private String email;
    private String phone;
    @ManyToMany
    private List<Books> books;

    public Readers() {
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(Integer libraryCard) {
        this.libraryCard = libraryCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Readers{" +
                "readerId=" + readerId +
                ", libraryCard=" + libraryCard +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", books=" + books +
                '}';
    }
}
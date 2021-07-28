package fasttrackit.ro.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Borrows {
    @Id
    @GeneratedValue
    private Long borrowId;
    private Date issuedDate;
    private Date returnDate;
    private String remarks;
    private Long bookId;
    private Long readerId;

    public Borrows() {
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    @Override
    public String toString() {
        return "Borrows{" +
                "borrowId=" + borrowId +
                ", issuedDate=" + issuedDate +
                ", returnDate=" + returnDate +
                ", remarks='" + remarks + '\'' +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                '}';
    }
}

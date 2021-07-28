package fasttrackit.ro.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Borrows {
    @Id
    @GeneratedValue
    private int borrowId;
    private Date issuedDate;
    private Date returnDate;
    private String remarks;
    private int bookId;
    private int readerId;
}

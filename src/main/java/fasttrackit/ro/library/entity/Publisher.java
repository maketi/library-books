package fasttrackit.ro.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private int publisherId;
    private String publisherName;
    private int publicationYear;

}

package fasttrackit.ro.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity()
public class Readers {
    @Id
    @Column(name = "reader_id")
    @GeneratedValue()
    private Long readerId;
    @Column(name = "card_id")
    private String libraryCard;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    private String email;
    private String phone;

    public Readers() {
    }
}
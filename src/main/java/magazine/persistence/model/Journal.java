package magazine.persistence.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "journals")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journal_id")
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "journal", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Article> articles = new ArrayList<>();

    @ManyToMany(mappedBy = "journals")
    @Transient
    @ToString.Exclude
    private List<User> users = new ArrayList<>();

    public Journal() {
    }

    public Journal(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

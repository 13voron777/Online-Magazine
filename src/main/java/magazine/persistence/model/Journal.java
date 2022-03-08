package magazine.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "journals", schema = "onlineMagazine")
@Getter
@Setter
public class Journal {
    @Id
    @Column(name = "journal_id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "journal", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Article> articles = new ArrayList<>();

    public Journal() {
    }

    public Journal(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return id == journal.id && Objects.equals(name, journal.name) && Objects.equals(description, journal.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}

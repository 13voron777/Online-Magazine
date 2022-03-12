package magazine.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "articles")
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;
    private String header;
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "journal")
    private Journal journal;

    public Article() {
    }

    public Article(long id, String header, String content, Journal journal) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.journal = journal;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id && Objects.equals(header, article.header) && Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, header, content);
    }
}


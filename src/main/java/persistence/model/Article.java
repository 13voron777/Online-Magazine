package persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "articles", schema = "onlineMagazine")
@Getter
@Setter
public class Article {
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "header")
    private String header;

    @Basic
    @Column(name = "content")
    private String content;

    public Article() {
    }

    public Article(long id, String header, String content) {
        this.id = id;
        this.header = header;
        this.content = content;
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

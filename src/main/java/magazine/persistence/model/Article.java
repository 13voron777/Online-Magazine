package magazine.persistence.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "articles")
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

    public Article(String header, String content, Journal journal) {
        this.header = header;
        this.content = content;
        this.journal = journal;
    }
}


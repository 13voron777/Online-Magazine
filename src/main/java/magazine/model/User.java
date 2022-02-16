package magazine.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "onlineMagazine")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "login")
    private String login;

    @Basic
    @Column(name = "password")
    private String password;


}

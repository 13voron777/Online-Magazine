package magazine.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "user_roles", schema = "onlineMagazine")
@Getter
@Setter
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "role_id")
    private Long id;
    private String role;
    @Basic
    @Column(name = "username")
    private String login;

    @ManyToOne
    @Transient
    private User user;

    @Override
    public String getAuthority() {
        return getRole();
    }
}

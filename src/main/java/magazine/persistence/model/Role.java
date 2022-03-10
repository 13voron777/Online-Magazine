package magazine.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity(name = "user_roles")
@Getter
@Setter
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    private String role;
    private String username;
    @ManyToOne
    @Transient
    private User user;

    @Override
    public String getAuthority() {
        return getRole();
    }
}

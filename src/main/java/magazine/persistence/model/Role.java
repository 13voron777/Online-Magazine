package magazine.persistence.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "user_roles")
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

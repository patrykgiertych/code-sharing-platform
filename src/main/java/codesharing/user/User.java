package codesharing.user;

import codesharing.code.Code;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.*;


@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Transient
    private boolean locked;
    private boolean enabled = true;

    @ManyToMany
    @JoinTable(
            name = "code_user",
            joinColumns = @JoinColumn(name = "code_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Code> codeList = new HashSet<>();


    public User(String username, String password, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    @Override @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override @JsonIgnore
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override @JsonIgnore
    public boolean isEnabled() {
        return enabled;
    }

    @Override @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    public void addCode(Code code) {
        codeList.add(code);
    }

}

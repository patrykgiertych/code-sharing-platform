package codesharing.user;


import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static codesharing.user.UserPermission.*;


public enum UserRole {
    USER(Sets.newHashSet(SNIPPET_ADD, SNIPPET_READ, SNIPPET_EDIT, SNIPPET_DELETE)),
    ADMIN(Sets.newHashSet(USER_ADD, USER_READ, USER_EDIT, USER_DELETE,
             SNIPPET_READ, SNIPPET_EDIT, SNIPPET_DELETE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}

package codesharing.security;


import com.google.common.collect.Sets;

import java.util.Set;

import static codesharing.security.AppUserPermission.*;


public enum AppUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_ADD, USER_READ, USER_EDIT, SNIPPET_ADD, SNIPPET_READ, SNIPPET_EDIT));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }
}

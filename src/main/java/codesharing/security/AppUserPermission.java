package codesharing.security;

public enum AppUserPermission {
    USER_ADD("user:add"),
    USER_READ("user:read"),
    USER_EDIT("user:edit"),
    SNIPPET_ADD("snippet:add"),
    SNIPPET_READ("snippet:read"),
    SNIPPET_EDIT("snippet:edit");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

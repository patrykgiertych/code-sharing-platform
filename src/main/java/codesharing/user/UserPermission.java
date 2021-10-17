package codesharing.user;

public enum UserPermission {
    USER_ADD("user:add"),
    USER_READ("user:read"),
    USER_EDIT("user:edit"),
    USER_DELETE("user:delete"),
    SNIPPET_ADD("snippet:add"),
    SNIPPET_READ("snippet:read"),
    SNIPPET_EDIT("snippet:edit"),
    SNIPPET_DELETE("snippet:delete");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

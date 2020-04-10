package pl.h2security.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum Role {

    USER_ROLE("USER_ROLE"),
    ADMIN_ROLE("ADMIN_ROLE");


    String description;

    public String getDescription() {
        return description;
    }

    Role(String description) {
        this.description = description;
    }

    public static Optional<Role> fromDescription(String description) {
        Role[] values = values();
        for (Role role : values) {
            if (role.getDescription().equals(description))
                return Optional.of(role);
        }
        return Optional.empty();
    }
}

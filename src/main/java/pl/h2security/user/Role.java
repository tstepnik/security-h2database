package pl.h2security.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum Role {

    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

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

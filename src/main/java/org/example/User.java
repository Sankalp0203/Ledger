package org.example;

import java.util.Objects;

public class User {
    public String getName() {
        return Name;
    }

    public User(String name) {
        Name = name;
    }

    private final String Name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Name, user.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);
    }
}

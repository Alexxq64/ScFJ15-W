package model;

import java.time.LocalDate;

public class User {
    private static long totalUsers = 1;
    private long id;

    public String getName() {
        return name;
    }

    private String name;
    private String surname;
    private LocalDate birthday;

    public User(String name, String surname, LocalDate birthday) {
        this.id = totalUsers++;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User: " + name + " " + surname + ". Birthday: " + birthday + "\n";
    }
}

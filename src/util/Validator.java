package util;

import model.User;

import java.time.LocalDate;
import java.time.Period;

public interface Validator {
    boolean validate(User user);
    static boolean isAdult(LocalDate birthday){
        return Period.between(birthday, LocalDate.now()).getYears()>= 18;
    };
}

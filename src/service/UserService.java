package service;

import model.User;
import util.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserService {
    private static UserService userService;
    private List<User> data = new ArrayList<>();

    {
        data.add(new User("Alex", "Panin", LocalDate.now().minusYears(20)));
        data.add(new User("Tom", "Panin", LocalDate.now().minusYears(10)));
        data.add(new User("Den", "Panin", LocalDate.now().minusYears(40)));
        data.add(new User("John", "Panin", LocalDate.now().minusYears(12)));
        data.add(new User("George", "Panin", LocalDate.now().minusYears(25)));
    }

    private UserService() {
        this.data = data;
    }

    public static UserService getInstance(){
        if (userService == null)
            userService = new UserService();
        return userService;
    }

    public Optional<User> getUserByID(int id) {
        if (id < data.size())
            return Optional.of(data.get(id));
        else return Optional.empty();
    }

    public List<User> getData() {
        return data;
    }

    public List<User> getValidUsers(Validator validator) {
        return data.stream()
                .filter(validator::validate)
//                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                .collect(Collectors.toList());
//        List<User> validUsers = new ArrayList<>();
//        for (User user : data) {
//            if (validator.validate(user))
//                validUsers.add(user);
//        }
//        return validUsers;
    }

    public List<User> getSortedUsers(Comparator<User> comparator){
        return data.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public Optional<User> getReducedUser(BinaryOperator<User> binaryOperator){
        return data.stream()
                .reduce(binaryOperator);
    }
}

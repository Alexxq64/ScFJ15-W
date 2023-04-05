import java.time.*;
import model.User;
import service.UserService;
import util.Validator;

public class Main {
    public static void main(String[] args) {
        UserService service = UserService.getInstance();

        Validator adultValidator = user -> Validator.isAdult(user.getBirthday());

        Validator youngValidator = user -> !Validator.isAdult(user.getBirthday());


        System.out.println(service.getValidUsers(adultValidator));
        System.out.println("=================================");
        System.out.println(service.getValidUsers(youngValidator));

        System.out.println(service.getSortedUsers(
                (u1, u2)-> - Period.between(u1.getBirthday(), u2.getBirthday()).getYears()));

        System.out.println(service.getReducedUser((u1, u2) ->
        {return Period.between(u1.getBirthday(), u2.getBirthday()).getYears() > 0 ? u1 : u2;}));
        System.out.println(service.getReducedUser((u1, u2) ->
        {return Period.between(u1.getBirthday(), u2.getBirthday()).getYears() < 0 ? u1 : u2;}));

        service.getUserByID(3).ifPresentOrElse(
                (System.out::println),
                ()-> System.out.println("No such user")
        );
    }
}
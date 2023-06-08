package hiber;
import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.add(new User("Andey", "Kobic", "user1@mail.ru", new Car("Mazda", 12345)));
        userService.add(new User("Vasia", "Lorentov", "user2@mail.ru", new Car("Tayta", 54321)));
        userService.add(new User("Petr", "Mashanin", "user3@mail.ru", new Car("BMV", 123)));
        userService.add(new User("Anton", "Titov", "user4@mail.ru", new Car("BMV", 3311)));


        userService.getUserByCarModelAndSeries("Mazda", 12345);
        System.out.println(userService.getUserByCarModelAndSeries("Mazda", 12345));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
        }

        context.close();
    }
}

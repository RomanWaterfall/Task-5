package hiber.service;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUserByCarModelAndSeries(String string, int series);

    @Transactional(readOnly = true)
    User getUserById(int id);

    @Transactional(readOnly = true)
    User getUserById(String model, int series);
}
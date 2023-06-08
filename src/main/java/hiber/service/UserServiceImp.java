package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User getUserByCarModelAndSeries(String string, int series) {
        return getUserById(string, series);
    }

    @Override
    public User getUserById(int id) {
        return getUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(String model, int series) {
        return userDao.getUserById(model, series);
    }


}


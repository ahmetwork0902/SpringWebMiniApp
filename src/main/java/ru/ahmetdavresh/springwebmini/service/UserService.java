package ru.ahmetdavresh.springwebmini.service;

import ru.ahmetdavresh.springwebmini.dto.UserDto;
import ru.ahmetdavresh.springwebmini.entity.User;
import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
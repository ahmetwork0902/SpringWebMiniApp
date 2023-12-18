package ru.ahmetdavresh.springwebmini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ahmetdavresh.springwebmini.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
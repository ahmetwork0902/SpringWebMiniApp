package ru.ahmetdavresh.springwebmini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ahmetdavresh.springwebmini.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
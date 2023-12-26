package ru.ahmetdavresh.springwebmini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ahmetdavresh.springwebmini.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
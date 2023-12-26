package ru.ahmetdavresh.springwebmini.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.ahmetdavresh.springwebmini.entity.Animal;
import ru.ahmetdavresh.springwebmini.repository.AnimalRepository;
import java.util.Optional;

@Slf4j
@Controller
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/list")
    public ModelAndView getAllAnimals() {
        log.info("/list -> connection");
        ModelAndView mav = new ModelAndView("list-animals");
        mav.addObject("animals", animalRepository.findAll());
        return mav;
    }

    @GetMapping("/addAnimalForm")
    public ModelAndView addAnimalForm() {
        ModelAndView mav = new ModelAndView("add-animal-form");
        Animal animal = new Animal();
        mav.addObject("animal", animal);
        return mav;
    }

    @PostMapping("/saveAnimal")
    public String saveAnimal(@ModelAttribute Animal animal) {
        animalRepository.save(animal);
        return "redirect:/list";
    }

    @GetMapping("/showAnimalUpdateForm")
    public ModelAndView showAnimalUpdateForm(@RequestParam Long animalId) {
        ModelAndView mav = new ModelAndView("add-animal-form");
        Optional<Animal> optionalAnimal = animalRepository.findById(animalId);
        Animal animal = new Animal();
        if (optionalAnimal.isPresent()) {
            animal = optionalAnimal.get();
        }
        mav.addObject("animal", animal);
        return mav;
    }

    @GetMapping("/deleteAnimal")
    public String deleteAnimal(@RequestParam Long animalId) {
        animalRepository.deleteById(animalId);
        return "redirect:/list";
    }
}
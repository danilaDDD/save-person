package controller;

import exception.ParsePersonException;
import exception.SavePersonException;
import model.repository.PersonRepository;

public class Controller {
    PersonRepository personRepository;

    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void savePersonFromString(String data) throws ParsePersonException, SavePersonException {
        personRepository.savePersonFromString(data);
    }
}

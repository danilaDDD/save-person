package model.repository.impl;

import exception.ParsePersonException;
import exception.SavePersonException;
import model.Person;
import model.parser.PersonParser;
import model.repository.PersonRepository;
import model.saver.PersonSaver;

public class PersonRepositoryImpl implements PersonRepository {
    private final PersonParser personParser = new PersonParser();
    private final PersonSaver saver = new PersonSaver();

    @Override
    public void savePersonFromString(String data) throws ParsePersonException, SavePersonException {
        Person person = personParser.parse(data);
        saver.save(person);
    }
}

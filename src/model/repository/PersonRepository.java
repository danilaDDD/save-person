package model.repository;

import exception.ParsePersonException;
import exception.SavePersonException;

public interface PersonRepository {
    void savePersonFromString(String data) throws ParsePersonException, SavePersonException;
}

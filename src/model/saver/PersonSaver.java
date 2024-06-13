package model.saver;

import exception.SavePersonException;
import model.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PersonSaver {
    String filesDir = "files/person";

    public void save(Person person) throws SavePersonException{
        String fileName = person.getSecondName() + ".txt";
        File file = new File(filesDir, fileName);
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(person.toString() + "\n");
        } catch (IOException e) {
            throw new SavePersonException("Failed to save the user");
        }

    }
}

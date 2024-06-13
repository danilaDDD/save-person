package model.saver;

import exception.SavePersonException;
import model.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class PersonSaver {
    String filesDir = "files/person";

    public void save(Person person) throws SavePersonException {
        String fileName = person.getSecondName() + ".txt";
        File file = new File(filesDir, fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(person.toString() + "\n");
        } catch (FileNotFoundException e) {
            throw new SavePersonException("files/person directory is not exist");
        } catch (IOException e) {
            // Какой-то системный сбой, по которым не работает сохранение в файл. Выводим ошибку какая она есть
            throw new SavePersonException(e);
        }
    }

}

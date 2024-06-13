package model.parser;

import exception.ParsePersonException;
import model.Person;
import model.Sex;
import utils.DateUtils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonParser {
    public Person parse(String data) throws ParsePersonException{
        List<String> splitDataList = separateDataOrThrow(data);
        String[] fio = getFioOrThrow(splitDataList);
        LocalDate birthDay = parseDateOrThrow(splitDataList.remove(0));
        String phone = splitDataList.remove(0);
        checkPhoneOrThrow(phone);
        Sex sex = parseSexOrThrow(splitDataList.remove(0));

        return Person.builder()
                .setFirstName(fio[0])
                .setSecondName(fio[1])
                .setLastName(fio[2])
                .setBirthDay(birthDay)
                .setPhone(phone)
                .setSex(sex)
                .build();
    }

    private String[] getFioOrThrow(List<String> splitDataList) throws ParsePersonException {
        String[] fio = new String[3];
        for (int i = 0; i < 3; i++) {
            fio[i] = splitDataList.remove(0);
            if(!isLatinOrCyrillic(fio[i]))
                throw new ParsePersonException(String.format("%s must be contain latin or cyrillic letters only", fio[i]));
        }

        return fio;
    }

    private boolean isLatinOrCyrillic(String s) {
        return Pattern.matches("^[А-Яа-я]+$", s) || Pattern.matches("^[a-zA-Z]+$", s);
    }


    private List<String> separateDataOrThrow(String data) throws ParsePersonException {
        String[] arrayData = data.split(" ");
        if(arrayData.length != 6)
            throw new ParsePersonException("The data line must be count 6 parts");

        return new LinkedList<>((List.of(arrayData)));
    }

    private LocalDate parseDateOrThrow(String dateString) throws ParsePersonException {
        try{
            return DateUtils.parse(dateString);
        }catch (DateTimeParseException e){
            throw new ParsePersonException("The birth day must be in 01.12.1996 format");
        }
    }

    private void checkPhoneOrThrow(String phone) throws ParsePersonException {
        if (!Pattern.matches("^(\\+7|8)\\d{10}$", phone))
            throw new ParsePersonException("phone was given in wrong format");
    }

    private Sex parseSexOrThrow(String stringSex) throws ParsePersonException {
        if(stringSex.equals("f"))
            return Sex.FEMALE;
        else if (stringSex.equals("m")) {
            return Sex.MALE;
        }else
            throw new ParsePersonException("The person sex must be \"f\" or \"m\" format");
    }
}

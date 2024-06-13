package model;

import utils.DateUtils;

import java.time.LocalDate;
import java.util.Date;

public class Person {
    private String firstName, secondName, lastName, phone;
    private LocalDate birthDay;
    private Sex sex;

    public Person(Builder builder){
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.lastName = builder.secondName;
        this.birthDay = builder.birthDay;
        this.phone = builder.phone;
        this.sex = builder.sex;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>", firstName, secondName, lastName, DateUtils.toString(birthDay), phone,
                sex == Sex.MALE ? "m": "f");
    }

    public static class Builder{
        private String firstName, secondName, lastName, phone;
        private LocalDate birthDay;
        private Sex sex;

        public Builder setBirthDay(LocalDate birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder setSex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }


}

package group.person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BuilderPerson {
    Person person = new Person();
    public BuilderPerson name(String name) {
        person.setName(name);
        return this;
    }
    public BuilderPerson surname(String surname) {
        person.setSurname(surname);
        return this;
    }
    public BuilderPerson id(int id) {
        person.setId(id);
        return this;
    }
    public BuilderPerson age(int age) {
        person.setAge(age);
        return this;
    }
    public BuilderPerson salary(double salary) {
        person.setSalary(salary);
        return this;
    }
    public BuilderPerson passport(String passport) {
        person.setPassport(passport);
        return this;
    }
    public BuilderPerson address(String address) {
        person.setAddress(address);
        return this;
    }
    public BuilderPerson dateOfBirthday(LocalDate dateOfBirthday) {
        person.setDateOfBirthday(dateOfBirthday);
        return this;
    }
    public BuilderPerson dateTimeCreate(LocalDateTime dateTimeCreate) {
        person.setDateTimeCreate(dateTimeCreate);
        return this;
    }
    public BuilderPerson timeToLunch(LocalTime timeToLunch) {
        person.setTimeToLunch(timeToLunch);
        return this;
    }
    public BuilderPerson letter(String letter) {
        person.setLetter(letter);
        return this;
    }
    public Person build() {
        return person;
    }
}

package group.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Person implements Serializable {
    private String name, surname;
    private int id, age;
    private double salary;
    private String passport;
    private String address;
    private LocalDate dateOfBirthday;
    private LocalDateTime dateTimeCreate;
    private LocalTime timeToLunch;
    private String letter;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public LocalDateTime getDateTimeCreate() {
        return dateTimeCreate;
    }

    public LocalTime getTimeToLunch() {
        return timeToLunch;
    }

    public String getLetter() {
        return letter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public void setDateTimeCreate(LocalDateTime dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public void setTimeToLunch(LocalTime timeToLunch) {
        this.timeToLunch = timeToLunch;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
    public static BuilderPerson builder(){
        return new BuilderPerson();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", dateTimeCreate=" + dateTimeCreate +
                ", timeToLunch=" + timeToLunch +
                ", letter='" + letter + '\'' +
                '}';
    }
}

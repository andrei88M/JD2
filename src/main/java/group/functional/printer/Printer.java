package group.functional.printer;

import group.person.Person;

import java.util.List;
import java.util.ResourceBundle;

public class Printer {

    public static void printPeople(List<Person> group) {
        group.forEach(System.out::println);
    }
    public static void printNameSurname(List<String> stringList) {
        stringList.forEach(System.out::println);
    }
    public static void printSelection(Selection moreOrLess, int age, List<Person> group) {
        switch (moreOrLess) {
            case LESS_THAN -> group.stream().filter(person -> person.getAge() < age).forEach(System.out::println);
            case MORE_THAN -> group.stream().filter(person -> person.getAge() > age).forEach(System.out::println);
        }
    }

    public static void printStrListAndResources(List<String> strList) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("res");
        String str = resourceBundle.getString("info");
        strList.forEach((s) -> System.out.println(str + "  " + s));
    }
}

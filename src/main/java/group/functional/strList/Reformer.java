package group.functional.strList;

import group.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Reformer {
    public static void transform(List<Person> group, List<String> strList) {
        if (!strList.isEmpty()) {
            strList.clear();
        }
        for (Person p : group) {
            String surname = p.getSurname();
            String name = p.getName();
            strList.add(surname + "_" + name);
        }
    }
}

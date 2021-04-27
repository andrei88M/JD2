package group.person;

import group.person.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sorter {
    public static void sorting(List<Person> group, Comparator<Person> comparator) {
        Set<Person> set = new TreeSet<>(comparator);
        set.addAll(group);
        group.clear();
        group.addAll(set);
    }
}
